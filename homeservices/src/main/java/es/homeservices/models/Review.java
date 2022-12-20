package es.homeservices.models;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private Integer score;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Review() {}

    public Review(String comment, Integer score, User user) {
        this.comment = comment;
        this.score = score;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public Integer getScore() {
        return score;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setUser(User user) {
        this.user = user;
    }

}