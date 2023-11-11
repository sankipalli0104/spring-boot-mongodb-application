package spring.boot.mongo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.boot.mongo.demo.document.ScheduleJobDetails;

import java.util.Optional;

public interface ScheduleJobRepository extends MongoRepository<ScheduleJobDetails, String> {
    Optional<ScheduleJobDetails> findByjobName(String jobName);
}
