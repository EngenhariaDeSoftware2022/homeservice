package es.homeservices.DTO;

import es.homeservices.models.Job;

public class SingleJobResponseDTO {

    private Job job;

    public SingleJobResponseDTO(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public Long getId() {
        return job.getId();
    }

    public String getTitle() {
        return job.getTitle();
    }

    public String getDescription() {
        return job.getDescription();
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
