package es.homeservices.services;

import java.util.List;

import es.homeservices.DTO.EditReviewDTO;
import es.homeservices.DTO.ReviewRequestDTO;
import es.homeservices.DTO.ReviewResponseDTO;
import es.homeservices.models.Review;
import es.homeservices.models.User;

public interface JobReviewService {

    ReviewResponseDTO addReview(User user, ReviewRequestDTO reviewDTO);

    List<ReviewResponseDTO> listReview(Long idJob);

    List<String> listComments(Long idJob);

    ReviewResponseDTO editReview(User user, EditReviewDTO reviewDTO);
    
   
}
