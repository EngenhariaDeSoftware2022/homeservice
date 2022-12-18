package es.homeservices.repositories;

import es.homeservices.models.Job;
import es.homeservices.models.UserJob;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
  Optional<Job> findById(Long jobId);
	Collection<Job> getAll();

}
