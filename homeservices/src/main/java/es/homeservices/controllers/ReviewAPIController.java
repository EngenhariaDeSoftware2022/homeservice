package es.homeservices.controllers;

import org.springframework.web.bind.annotation.*;

import es.homeservices.DTO.EditReviewDTO;
import es.homeservices.DTO.ReviewRequestDTO;
import es.homeservices.DTO.ReviewResponseDTO;
import es.homeservices.services.JobReviewService;
import es.homeservices.models.Review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/api")
public class ReviewAPIController {
    
    @Autowired
    private JobReviewService jobReviewService;

    @PostMapping(value = "/addReview")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponseDTO addReview(@RequestBody ReviewRequestDTO reviewDTO){
        return jobReviewService.addReview(reviewDTO);
    }

    @PostMapping(value = "/editReview")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponseDTO editReview(@RequestBody EditReviewDTO reviewDTO){
        return jobReviewService.editReview(reviewDTO);
    }

    @PostMapping(value = "/listReview")
    @ResponseStatus(HttpStatus.OK)
    public List<Review> listReviews(@RequestParam Long idJob){
        return jobReviewService.listReview(idJob);
    }

    @PostMapping(value = "/listComments")
    @ResponseStatus(HttpStatus.OK)
    public List<String> listComments(@RequestParam Long idJob){
        return jobReviewService.listComments(idJob);
    }
}