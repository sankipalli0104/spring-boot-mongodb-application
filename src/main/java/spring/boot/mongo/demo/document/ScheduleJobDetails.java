package spring.boot.mongo.demo.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Schedule_job_details")
@JsonIgnoreProperties
@JsonInclude
public class ScheduleJobDetails {

    @Id
    private String id;

    private String jobName;

    private boolean jobStatus;

    private Date lastRunTimeStamp;

    private Date nextRunTimeStamp;

    private long interval;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public boolean isJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(boolean jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Date getLastRunTimeStamp() {
        return lastRunTimeStamp;
    }

    public void setLastRunTimeStamp(Date lastRunTimeStamp) {
        this.lastRunTimeStamp = lastRunTimeStamp;
    }

    public Date getNextRunTimeStamp() {
        return nextRunTimeStamp;
    }

    public void setNextRunTimeStamp(Date nextRunTimeStamp) {
        this.nextRunTimeStamp = nextRunTimeStamp;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "ScheduleJobDetails{" +
                "id='" + id + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobStatus=" + jobStatus +
                ", lastRunTimeStamp=" + lastRunTimeStamp +
                ", nextRunTimeStamp=" + nextRunTimeStamp +
                ", interval=" + interval +
                '}';
    }
}
