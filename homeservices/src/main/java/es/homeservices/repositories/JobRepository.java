package es.homeservices.repositories;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import es.homeservices.models.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	
	Collection<Job> getAll();

    Optional<Job> findById(Long jobId);
	
}
