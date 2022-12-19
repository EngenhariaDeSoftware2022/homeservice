package es.homeservices.exception;

public class CpfInvalidException extends IllegalArgumentException{
    public CpfInvalidException(String cpf){
        super(String.format("Given cpf: %s is not valid", cpf));
    }
}
