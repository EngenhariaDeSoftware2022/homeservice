package es.homeservices.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.homeservices.models.Job;
import es.homeservices.models.JobReview;

public interface JobReviewRepository extends JpaRepository<JobReview, Long>{
    
    Optional<JobReview> findByJob(Job job);
}
