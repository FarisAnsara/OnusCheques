package org.SpringBoot.onus.Services.CustomerServices;

import org.SpringBoot.onus.Exceptions.CustomerExceptions.CustomerAlreadyExistsWithinBankException;
import org.SpringBoot.onus.Exceptions.CustomerExceptions.CustomerDoesNotExistException;
import org.SpringBoot.onus.Exceptions.CustomerExceptions.NameWithNullValueException;
import org.SpringBoot.onus.Exceptions.CustomerExceptions.NationalIdIsNullException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler(value = NameWithNullValueException.class)
    public static ResponseEntity<Object> handleNameWithNullValueException(NameWithNullValueException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = CustomerAlreadyExistsWithinBankException.class)
    public static ResponseEntity<Object> handleCustomerAlreadyExistsWithinBankException(CustomerAlreadyExistsWithinBankException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = NationalIdIsNullException.class)
    public static ResponseEntity<Object> handleNationalIdIsNullException(NationalIdIsNullException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = CustomerDoesNotExistException.class)
    public static ResponseEntity<Object> handleCustomerDoesNotExistException(CustomerDoesNotExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}