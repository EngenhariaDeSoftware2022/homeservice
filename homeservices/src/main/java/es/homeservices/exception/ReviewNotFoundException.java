package es.homeservices.exception;

import javax.persistence.EntityExistsException;

public class ReviewNotFoundException extends EntityExistsException {
    public ReviewNotFoundException(Long id){
        super(String.format("Review with ID: %s was not found", id));
    }
}
