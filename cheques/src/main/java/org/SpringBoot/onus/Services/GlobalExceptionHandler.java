package org.SpringBoot.onus.Services;

import org.SpringBoot.onus.Exceptions.NameWithNullValueException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = NameWithNullValueException.class)
    public static ResponseEntity<Object> exception(NameWithNullValueException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}