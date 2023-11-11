package spring.boot.mongo.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.boot.mongo.demo.document.ScheduleJobDetails;
import spring.boot.mongo.demo.repository.ScheduleJobRepository;

import java.util.Optional;

@Configuration
public class AppConfig {

//    @Value("${scheduling.interval}")
//    private long schedulingInterval;
//
//    public long getSchedulingInterval() {
//        return schedulingInterval;
//    }
//
//    public void setSchedulingInterval(long schedulingInterval) {
//        this.schedulingInterval = schedulingInterval;
//    }

    @Autowired
    private ScheduleJobRepository scheduleJobRepository;


    @Bean
    public String getCronValue(){

        Optional<ScheduleJobDetails> test = scheduleJobRepository.findByjobName("TEST");
        if(test.isPresent()){
            ScheduleJobDetails scheduleJobDetails = test.get();

            return null;//scheduleJobDetails.getInterval();
        }
        return "0 */3 * * * ?";
    }


}
