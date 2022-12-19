package es.homeservices.DTO;

public class ReviewRequestDTO {
    
    private Long idJob;
    private String cpfUser;

    private Integer score;
    private String comment;


    public ReviewRequestDTO(String cpfUser, Long idJob, String comment, Integer score) {
        this.cpfUser = cpfUser;
        this.idJob = idJob;
        this.comment = comment;
        this.score = score;
    }

    public String getCpfUser() {
        return cpfUser;
    }

    public void setCpfUser(String cpfUser) {
        this.cpfUser = cpfUser;
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
