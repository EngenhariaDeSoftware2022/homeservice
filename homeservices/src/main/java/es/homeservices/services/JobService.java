package es.homeservices.services;

import java.util.Collection;

import es.homeservices.models.Job;

public interface JobService {
	
	Collection<Job> listJobs();
	
}
