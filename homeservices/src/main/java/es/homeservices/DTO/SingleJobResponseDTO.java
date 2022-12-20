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

    public void setJob(Job job) {
        this.job = job;
    }
}