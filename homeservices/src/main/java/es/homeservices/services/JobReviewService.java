package es.homeservices.services;

import java.util.List;

import es.homeservices.DTO.EditReviewDTO;
import es.homeservices.DTO.ReviewRequestDTO;
import es.homeservices.DTO.ReviewResponseDTO;
import es.homeservices.models.Review;

public interface JobReviewService {

    ReviewResponseDTO addReview(ReviewRequestDTO reviewDTO);

    List<Review> listReview(Long idJob);

    List<String> listComments(Long idJob);

    ReviewResponseDTO editReview(EditReviewDTO reviewDTO);
    
   
}