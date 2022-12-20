package es.homeservices.exception;

import javax.persistence.EntityNotFoundException;

public class JobNotFoundException extends EntityNotFoundException  {
    
    public JobNotFoundException(Long idJob){
        super(String.format("Job with ID: %s was not found", idJob));
    }
}