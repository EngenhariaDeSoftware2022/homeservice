package es.homeservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.homeservices.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    
}
