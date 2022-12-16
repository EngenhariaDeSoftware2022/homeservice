package es.homeservices.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.homeservices.models.Job;
import es.homeservices.repositories.JobRepository;

@Service
public class JobServiceImpl implements JobService {
	
	private final JobRepository jobRepository;
	
	@Autowired
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
	
	public Collection<Job> listJobs() {
		return this.jobRepository.getAll();
	}
	
}
