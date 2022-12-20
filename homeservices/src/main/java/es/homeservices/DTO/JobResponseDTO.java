package es.homeservices.DTO;

import es.homeservices.models.Job;

public class JobResponseDTO {

    private Long jobId;
    private String title;

    public JobResponseDTO(Long jobId, String title) {
        this.jobId = jobId;
        this.title = title;
    }

    public JobResponseDTO(Job job) {
        this.jobId = job.getId();
        this.title = job.getTitle();
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}