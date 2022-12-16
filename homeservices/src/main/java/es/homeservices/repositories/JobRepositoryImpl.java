package es.homeservices.repositories;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import es.homeservices.models.Job;

@Repository
public abstract class JobRepositoryImpl implements JobRepository {
	
	public Collection<Job> getAll() {
		return this.findAll();
	}
	
}
