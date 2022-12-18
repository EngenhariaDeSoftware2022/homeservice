package es.homeservices.exception;

import javax.persistence.EntityNotFoundException;

public class UserJobNotFoundException extends EntityNotFoundException {
    public UserJobNotFoundException(Long userId){
        super(String.format("User Jobs with User Id: %s was not found", userId));
    }
}
