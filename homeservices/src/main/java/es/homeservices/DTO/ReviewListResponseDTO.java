package es.homeservices.DTO;

import es.homeservices.models.Review;

import java.util.List;
import java.util.stream.Collectors; 

public class ReviewListResponseDTO {
    
    private List<ReviewResponseDTO> reviews;

    public ReviewListResponseDTO(List<Review> reviews){
        this.reviews = reviews.stream().map(review -> new ReviewResponseDTO(review.getUser().getName(), review.getScore(), review.getComment())).collect(Collectors.toList());
    }

    public ReviewListResponseDTO(){
    }

    public List<ReviewResponseDTO> getReviews(){
        return reviews;
    }

    public void setReviews(List<Review> reviews){
        this.reviews = reviews.stream().map(review -> new ReviewResponseDTO(review.getUser().getName(), review.getScore(), review.getComment())).collect(Collectors.toList());
    }
}
