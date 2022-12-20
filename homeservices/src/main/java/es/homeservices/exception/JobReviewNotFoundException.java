package es.homeservices.exception;

import javax.persistence.EntityNotFoundException;

public class JobReviewNotFoundException extends EntityNotFoundException{
    
    public JobReviewNotFoundException(Long idJobReview){
        super(String.format("Job Reviews with Job Id: %s was not found", idJobReview));
    }
}