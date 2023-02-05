package es.homeservices.services;

import java.util.Collection;

import es.homeservices.models.Job;
import es.homeservices.models.enumeration.Tag;

public interface JobService {
	
	Collection<Job> listJobs();
	
	Tag[] listTags();

	Collection<Job> filterJobsByTag(Tag tag);
	
}
