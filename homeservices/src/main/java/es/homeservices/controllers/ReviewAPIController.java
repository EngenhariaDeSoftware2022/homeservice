package es.homeservices.controllers;

import es.homeservices.models.SecurityUser;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public ReviewResponseDTO addReview(@AuthenticationPrincipal SecurityUser securityUser,
                                       @RequestBody ReviewRequestDTO reviewDTO){
        return jobReviewService.addReview(securityUser.getUser(), reviewDTO);
    }

    @PatchMapping(value = "/editReview")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponseDTO editReview(@AuthenticationPrincipal SecurityUser securityUser,
                                        @RequestBody EditReviewDTO reviewDTO){
        return jobReviewService.editReview(securityUser.getUser(), reviewDTO);
    }

    @GetMapping(value = "/listReview")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponseDTO> listReviews(@RequestParam Long idJob){
        return jobReviewService.listReview(idJob);
    }

    @GetMapping(value = "/listComments")
    @ResponseStatus(HttpStatus.OK)
    public List<String> listComments(@RequestParam Long idJob){
        return jobReviewService.listComments(idJob);
    }
}
