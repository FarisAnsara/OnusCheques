package org.SpringBoot.onus.Services.BankServices;

import org.SpringBoot.onus.Exceptions.BankExceptions.BankAlreadyExistsException;
import org.SpringBoot.onus.Exceptions.BankExceptions.BankIsInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankExceptionHandler {

    @ExceptionHandler(value = BankAlreadyExistsException.class)
    public static ResponseEntity<Object> handleBankAlreadyExistException(BankAlreadyExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = BankIsInvalidException.class)
    public static ResponseEntity<Object> handleBankIsInvalidException(BankIsInvalidException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
