package es.homeservices.exception;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(String cpf){
        super(String.format("User with CPF: %s was not found", cpf));
    }

}
