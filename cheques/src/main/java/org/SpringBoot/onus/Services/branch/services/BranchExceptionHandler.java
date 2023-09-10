package org.SpringBoot.onus.Services.branch.services;

import org.SpringBoot.onus.Exceptions.BranchExceptions.BranchIsInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BranchExceptionHandler {

    @ExceptionHandler(value = BranchIsInvalidException.class)
    public ResponseEntity<Object> handleBranchIsInvalidException(BranchIsInvalidException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
