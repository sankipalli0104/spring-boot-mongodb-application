package spring.boot.mongo.demo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import spring.boot.mongo.demo.config.AppConfig;
import spring.boot.mongo.demo.document.ScheduleJobDetails;
import spring.boot.mongo.demo.repository.ScheduleJobRepository;

import java.util.Date;
import java.util.Optional;

//@Configuration
@Slf4j
@Component
public class SchedulerTasks {

    @Autowired
    private ScheduleJobRepository scheduleJobRepository;



    private static final Logger logger = LoggerFactory.getLogger(SchedulerTasks.class);

    //@Value("${scheduling.interval}")
    private long schedulingInterval;

    //@Scheduled(cron = "#{@getCronValue}")
    public void checkSchedulejob() {
        logger.info("Schedule Job Started");
//        Date currentRunTime = new Date();
//        Date nextRun = new Date(System.currentTimeMillis() + 30000);
//        Optional<ScheduleJobDetails> jobDetails = scheduleJobRepository.findByjobName("Test");
//        if (jobDetails.isPresent()) {
//            ScheduleJobDetails scheduleJobDetails = jobDetails.get();
//            if (scheduleJobDetails.isJobStatus()) {
//                Date lastRunTimeStamp = scheduleJobDetails.getLastRunTimeStamp();
//                Date nextRunTimeStamp = scheduleJobDetails.getNextRunTimeStamp();
//                logger.info("Last Schedule TimeStamp {}", lastRunTimeStamp);
//                //logger.info("Next Schedule TimeStamp {}", nextRunTimeStamp);
//                if (currentRunTime.compareTo(nextRunTimeStamp) >= 0) {
//                    //excute the logic
//                    logger.info("Executing the schedule Job");
//                    scheduleJobDetails.setLastRunTimeStamp(currentRunTime);
//                    scheduleJobDetails.setNextRunTimeStamp(nextRun);
//                    //logger.info("Next Schedule job Run TimeStamp {}", new Date(System.currentTimeMillis() + 43200000));
//                    scheduleJobRepository.save(scheduleJobDetails);
//                }
//            }
//
//        }
        logger.info("Schedule Job Completed");
    }
}
