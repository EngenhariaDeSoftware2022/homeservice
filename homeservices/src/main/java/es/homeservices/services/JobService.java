package es.homeservices.services;

import java.util.Collection;

import es.homeservices.DTO.SingleJobResponseDTO;
import es.homeservices.models.Job;
import es.homeservices.models.enumeration.Tag;

public interface JobService {
	Collection<Job> listJobs();
	SingleJobResponseDTO getJobByTitle(String title, String cpf);
	Tag[] listTags();
	
}