package es.homeservices.DTO;

public class ReviewRequestDTO {
    
    private Long idJob;
    private Integer score;
    private String comment;


    public ReviewRequestDTO(Long idJob, String comment, Integer score) {
        this.idJob = idJob;
        this.comment = comment;
        this.score = score;
    }

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
