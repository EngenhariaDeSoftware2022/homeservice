package es.homeservices.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import es.homeservices.models.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	
    Optional<Job> findById(Long jobId);
	
}
