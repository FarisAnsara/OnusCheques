package org.SpringBoot.onus.Services.ChequeServices;

import org.SpringBoot.onus.Exceptions.ChequeExceptions.ChequeDoesNotExistException;
import org.SpringBoot.onus.Exceptions.ChequeExceptions.ChequeIsDuplicateException;
import org.SpringBoot.onus.Exceptions.ChequeExceptions.NotAnOnusChequeOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChequeExceptionHandler {

    @ExceptionHandler(value = ChequeDoesNotExistException.class)
    public ResponseEntity<Object> handleChequeDoesNotExistException(ChequeDoesNotExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NotAnOnusChequeOperationException.class)
    public ResponseEntity<Object> handleNotAnOnusChequeOperationException(NotAnOnusChequeOperationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = ChequeIsDuplicateException.class)
    public ResponseEntity<Object> handleChequeIsDuplicateException(ChequeIsDuplicateException e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
    }
}

