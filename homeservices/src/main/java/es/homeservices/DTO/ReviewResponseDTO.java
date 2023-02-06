package es.homeservices.DTO;

import es.homeservices.models.Review;

public class ReviewResponseDTO {

    private Long reviewId;

    private String nameUser;
    
    private Integer score;
    private String comment;

    public ReviewResponseDTO(Long id, String nameUser, Integer score, String comment) {
        this.reviewId = id;
        this.nameUser = nameUser;
        this.score = score;
        this.comment = comment;
    }
    public ReviewResponseDTO(Review review) {
        this.reviewId = review.getId();
        this.nameUser = review.getUser().getName();
        this.score = review.getScore();
        this.comment = review.getComment();
    }

    public ReviewResponseDTO(String nameUser, Integer score, String comment) {
        this.nameUser = nameUser;
        this.score = score;
        this.comment = comment;
    }
    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
}
