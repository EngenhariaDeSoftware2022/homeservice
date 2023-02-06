package es.homeservices.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import es.homeservices.DTO.EditReviewDTO;
import es.homeservices.DTO.ReviewRequestDTO;
import es.homeservices.DTO.ReviewResponseDTO;
import es.homeservices.exception.JobNotFoundException;
import es.homeservices.exception.JobReviewNotFoundException;
import es.homeservices.exception.ReviewNotFoundException;
import es.homeservices.models.Job;
import es.homeservices.models.JobReview;
import es.homeservices.models.Review;
import es.homeservices.models.User;
import es.homeservices.repositories.JobRepository;
import es.homeservices.repositories.JobReviewRepository;
import es.homeservices.repositories.ReviewRepository;
import es.homeservices.repositories.UserRepository;

@Service
public class JobReviewServiceImpl implements JobReviewService{

    @Autowired
    private JobReviewRepository jobReviewRepository;

    @Autowired 
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;


    @Override
    public ReviewResponseDTO addReview(User user, ReviewRequestDTO reviewDTO) {
        Optional<Job> jobOp = jobRepository.findById(reviewDTO.getIdJob());
        Job job = jobOp.orElseThrow(() -> new JobNotFoundException(reviewDTO.getIdJob()));

        Optional<JobReview> jobReviewOp = jobReviewRepository.findByJob(job);
        JobReview jobReview = null;

        if(!jobReviewOp.isPresent()){
            jobReview = new JobReview(job, new ArrayList<>());
            jobReviewRepository.save(jobReview);
        }else{
            jobReview = jobReviewOp.get();
        }

        Review review = new Review(reviewDTO.getComment(), reviewDTO.getScore(), user);
        jobReview.addReview(review);

        jobReviewRepository.save(jobReview);

        return new ReviewResponseDTO(user.getName(), review.getScore(), review.getComment());
    }

    @Override
    public List<ReviewResponseDTO> listReview(Long idJob) {
        Optional<Job> jobOp = jobRepository.findById(idJob);
        Job job = jobOp.orElseThrow(() -> new JobNotFoundException(idJob));

        Optional<JobReview> jobReviewOp = jobReviewRepository.findByJob(job);
        JobReview jobReview = jobReviewOp.orElseThrow(() -> new JobReviewNotFoundException(idJob));

        List<ReviewResponseDTO> reviewsDTO = new ArrayList<>();
        for(Review r : jobReview.getReviews()){
            reviewsDTO.add(new ReviewResponseDTO(r));
        }
        return reviewsDTO;
    }

    @Override
    public List<String> listComments(Long idJob) {
        Optional<Job> jobOp = jobRepository.findById(idJob);
        Job job = jobOp.orElseThrow(() -> new JobNotFoundException(idJob));

        Optional<JobReview> jobReviewOp = jobReviewRepository.findByJob(job);
        JobReview jobReview = jobReviewOp.orElseThrow(() -> new JobReviewNotFoundException(idJob));

        return jobReview.getReviews().stream().map(review -> review.getComment()).collect(Collectors.toList());
    }

    @Override
    public ReviewResponseDTO editReview(User user, EditReviewDTO reviewDTO) throws AccessDeniedException {
        Optional<Job> jobOp = jobRepository.findById(reviewDTO.getIdJob());
        Job job = jobOp.orElseThrow(() -> new JobNotFoundException(reviewDTO.getIdJob()));

        Optional<JobReview> jobReviewOp = jobReviewRepository.findByJob(job);
        JobReview jobReview = jobReviewOp.orElseThrow(() -> new JobReviewNotFoundException(reviewDTO.getIdJob()));

        Optional<Review> reviewOp = reviewRepository.findById(reviewDTO.getIdReview());
        Review review = reviewOp.orElseThrow(() -> new ReviewNotFoundException(reviewDTO.getIdReview()));
        if(!review.getUser().equals(user))
            throw new AccessDeniedException("User cannot edit this review");
        review.setComment(reviewDTO.getComents());
        review.setScore(reviewDTO.getScore());

        jobReviewRepository.save(jobReview);


        return new ReviewResponseDTO(review.getId(), review.getUser().getName(), review.getScore(), review.getComment());
    }


    
    
}
