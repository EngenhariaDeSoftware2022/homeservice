package es.homeservices.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class JobReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Job job;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    public JobReview() {}

    public JobReview(Job job, List<Review> reviews) {
        this.job = job;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

}