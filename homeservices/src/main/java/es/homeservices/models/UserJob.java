package es.homeservices.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class UserJob {

    @Id
    @GeneratedValue
    private Long userJobId;

    @OneToOne
    private User user;
    
    @OneToMany
    @MapKeyColumn(name = "JobId")
    @Column(name = "Job")
    private Map<Long, Job> jobs;

    public UserJob(User user) {
        this.user = user;
        this.jobs = new HashMap<Long, Job>();
    }

    public UserJob() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Long, Job> getJobs() {
        return jobs;
    }

    public void setJobs(Map<Long, Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job job) {
        this.jobs.put(job.getId(), job);
    }

    public Job getJob(Long jobId) {
        return this.jobs.get(jobId);
    }

    public void deleteJob(Long jobId) {
        this.jobs.remove(jobId);
    }
}
