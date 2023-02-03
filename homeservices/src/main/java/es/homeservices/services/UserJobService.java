package es.homeservices.services;

import es.homeservices.DTO.*;
import es.homeservices.models.Job;
import es.homeservices.models.User;

public interface UserJobService {

    //JobResponseDTO createJob(JobRequestDTO jobDTO);

    JobResponseDTO createJob(User user, JobRequestDTO jobDTO);

    JobListResponseDTO listUserJob(User user);

    JobResponseDTO editJob(User user, EditJobRequestDTO jobDTO);

    abstract Job getUserJob(User user, Long jobId);
    DeletedJobResponseDTO deleteJob(User user, Long jobId);
}
