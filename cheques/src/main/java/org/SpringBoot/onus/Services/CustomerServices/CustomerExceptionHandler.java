package org.SpringBoot.onus.Services.CustomerServices;

import org.SpringBoot.onus.Exceptions.CustomerExceptions.*;
import org.SpringBoot.onus.Exceptions.PayerExceptions.InsufficientBalanceException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
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

    @ExceptionHandler(value = InsufficientBalanceException.class)
    public ResponseEntity<Object> handleInsufficientBalanceException(InsufficientBalanceException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.PAYLOAD_TOO_LARGE);
    }

    @ExceptionHandler(value = CustomerStatusIsNotActive.class)
    public ResponseEntity<Object> handleCustomerStatusIsNotActive(CustomerStatusIsNotActive e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.LOCKED);
    }
}