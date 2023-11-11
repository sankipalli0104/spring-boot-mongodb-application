package spring.boot.mongo.demo.config;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import java.util.Date;

//public class CustomTrigger implements Trigger {

//    @Override
//    public Date nextExecution(TriggerContext triggerContext) {
//        // Implement your custom logic to calculate the next execution time
//        // You can use triggerContext to access the last execution time, last completion time, and the period
//        // Example logic to schedule a task every 10 seconds
//        Date lastExecutionTime = triggerContext.lastScheduledExecutionTime();
//        if (lastExecutionTime == null) {
//            return new Date(System.currentTimeMillis() + 10000); // Schedule immediately if never executed
//        } else {
//            return new Date(lastExecutionTime.getTime() + 10000); // Schedule every 10 seconds
//        }
//    }
//}
