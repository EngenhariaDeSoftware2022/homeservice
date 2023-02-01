package es.homeservices.services;

import es.homeservices.DTO.*;
import es.homeservices.models.User;

public interface UserJobService {

    JobResponseDTO createJob(JobRequestDTO jobDTO);

    JobResponseDTO createJob(User user, JobRequestDTO jobDTO);

    JobListResponseDTO listUserJob(String cpf);

    JobListResponseDTO listUserJob(User user);

    JobResponseDTO editJob(EditJobRequestDTO jobDTO);
    SingleJobResponseDTO getUserJob(String cpf, Long jobId);
    DeletedJobResponseDTO deleteJob(String cpf, Long jobId);
}
