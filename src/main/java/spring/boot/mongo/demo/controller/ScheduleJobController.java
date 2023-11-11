package spring.boot.mongo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.mongo.demo.document.ScheduleJobDetails;
import spring.boot.mongo.demo.repository.ScheduleJobRepository;
import spring.boot.mongo.demo.scheduler.SchedulerTasks;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/schedulejob")
public class ScheduleJobController {

    @Autowired
    private ScheduleJobRepository scheduleJobRepository;

    @Autowired
    private SchedulerTasks schedulerTasks;


    private static final Logger logger = LoggerFactory.getLogger(ScheduleJobController.class);

    @Autowired
    public ScheduleJobController(ScheduleJobRepository scheduleJobRepository) {
        this.scheduleJobRepository = scheduleJobRepository;
    }

//    @Autowired
//    private AppConfig appConfig;

    @GetMapping
    public List<ScheduleJobDetails> getAllSchedhuleJob() {
        logger.info("Request received URL:/schedulejob/getMapping");
        long startTime = System.currentTimeMillis();
        List<ScheduleJobDetails> scheduleJobDetailsList =  scheduleJobRepository.findAll();
        long endTime = System.currentTimeMillis();
        logger.info("Request Successful URL:/schedulejob/getMapping. Response Time {} ms",startTime-endTime);
        return scheduleJobDetailsList;
    }

    @PostMapping
    public ScheduleJobDetails addProduct(@RequestBody ScheduleJobDetails scheduleJobDetails) {
        return scheduleJobRepository.save(scheduleJobDetails);
    }

    @PostMapping("/changeInterval/{interval}")
    public String changeSchedulingInterval(@PathVariable long interval) {
        //dynamicTaskScheduler.setFixedRate(interval);
        return "Scheduling interval changed to " + interval + " milliseconds.";
    }


}
