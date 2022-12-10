package es.homeservices.exception;

import javax.persistence.EntityExistsException;

public class UserExistsException extends EntityExistsException {
    public UserExistsException(String cpf){
        super(String.format("User with CPF: %s already registered", cpf));
    }
}
