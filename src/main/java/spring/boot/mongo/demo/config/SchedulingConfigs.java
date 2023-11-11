package spring.boot.mongo.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import spring.boot.mongo.demo.document.ScheduleJobDetails;
import spring.boot.mongo.demo.repository.ScheduleJobRepository;
import spring.boot.mongo.demo.scheduler.SchedulerTasks;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

@Configuration
@EnableScheduling
public class SchedulingConfigs implements SchedulingConfigurer {

    @Autowired
    private ScheduleJobRepository scheduleJobRepository;

    private static final Logger logger = LoggerFactory.getLogger(SchedulingConfigs.class);

    @Autowired
    private SchedulerTasks schedulerTasks;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
                                         @Override
                                         public void run() {
                                             schedulerTasks.checkSchedulejob();
                                             logger.info("Running Scheduler... {}", Calendar.getInstance().getTime());
                                         }
                                     },
                new Trigger() {
                    @Override
                    public Instant nextExecution(TriggerContext triggerContext) {
                        Date lastExecutionTime = triggerContext.lastScheduledExecutionTime();
                        long newInterval = 10000;
                        logger.info("getting the interval details from DB");
                        Optional<ScheduleJobDetails> test = scheduleJobRepository.findByjobName("TEST");
                        if (test.isPresent()) {
                            ScheduleJobDetails scheduleJobDetails = test.get();
                            logger.info("new interval: {}", scheduleJobDetails.getInterval());
                            newInterval = scheduleJobDetails.getInterval();
                        }
                        if (lastExecutionTime == null) {
                            return new Date(System.currentTimeMillis()).toInstant(); // Schedule immediately if never executed
                        } else {
                            return new Date(lastExecutionTime.getTime() + newInterval).toInstant(); // Schedule every 10 seconds
                        }
                    }
                });
    }


    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        scheduler.setPoolSize(1);
        scheduler.initialize();
        return scheduler;
    }
}
