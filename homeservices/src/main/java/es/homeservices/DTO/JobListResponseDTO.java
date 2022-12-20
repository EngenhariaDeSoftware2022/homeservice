package es.homeservices.DTO;

import es.homeservices.models.Job;

import java.util.List;

public class JobListResponseDTO {

    private List<Job> jobs;

    public JobListResponseDTO(List<Job> jobs) {
        this.jobs = jobs;
    }

    public JobListResponseDTO() {
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}