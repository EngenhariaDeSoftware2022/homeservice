package es.homeservices.repositories;

import es.homeservices.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
  Optional<Job> findById(Long jobId);

  List<Job> findByTitleIgnoreCase(String title);
}
