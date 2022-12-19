package es.homeservices.DTO;

public class EditReviewDTO {
    
    private Long idJob;
    private Long idReview;

    private Integer score;
    private String coments;

    public EditReviewDTO(Long idJob, Long idReview, String coments, Integer score) {
        this.idJob = idJob;
        this.idReview = idReview;
        this.coments = coments;
        this.score = score;
    }


    public Long getIdJob() {
        return idJob;
    }
    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }
    public Long getIdReview() {
        return idReview;
    }
    public void setIdReview(Long idReview) {
        this.idReview = idReview;
    }
    public String getComents() {
        return coments;
    }
    public void setComents(String coments) {
        this.coments = coments;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    } 

}
