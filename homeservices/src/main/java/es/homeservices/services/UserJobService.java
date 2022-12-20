package es.homeservices.services;

import es.homeservices.DTO.*;

public interface UserJobService {

    JobResponseDTO createJob(JobRequestDTO jobDTO);
    JobListResponseDTO listUserJob(String cpf);
    JobResponseDTO editJob(EditJobRequestDTO jobDTO);
    SingleJobResponseDTO getUserJob(String cpf, Long jobId);
    DeletedJobResponseDTO deleteJob(String cpf, Long jobId);
}