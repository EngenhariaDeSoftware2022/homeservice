package es.homeservices.services;

import java.util.Collection;
import java.util.List;

import es.homeservices.DTO.JobListResponseDTO;
import es.homeservices.DTO.SingleJobResponseDTO;
import es.homeservices.models.Job;
import es.homeservices.models.enumeration.Tag;

public interface JobService {
	
	Collection<Job> listJobs();
	
	Tag[] listTags();


	JobListResponseDTO searchByTitle(String title, List<Tag> tags);

	List<Tag> stringToEnum(List<String> strTags);
}
