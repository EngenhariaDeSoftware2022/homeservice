package es.homeservices.exception;

import javax.persistence.EntityExistsException;

public class UserExistsException extends EntityExistsException {
    public UserExistsException(String data){
        super(String.format("User with this data: %s already registered", data));
    }

}
