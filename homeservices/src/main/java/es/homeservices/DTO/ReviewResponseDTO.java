package es.homeservices.DTO;

public class ReviewResponseDTO {
    
    private String nameUser;
    
    private Integer score;
    private String comment;

    public ReviewResponseDTO(String nameUser, Integer score, String comment) {
        this.nameUser = nameUser;
        this.score = score;
        this.comment = comment;
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
