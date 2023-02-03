package es.homeservices.exception;

import java.text.ParseException;
import java.time.format.DateTimeParseException;

public class DateFormatException extends IllegalArgumentException {

    public DateFormatException(String date){
        super(String.format("Given date: %s is not valid. Please format date as: dd/MM/yyyy", date));
    }

}
