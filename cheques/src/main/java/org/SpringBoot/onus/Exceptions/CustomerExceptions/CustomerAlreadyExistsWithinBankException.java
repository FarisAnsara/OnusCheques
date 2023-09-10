package org.SpringBoot.onus.Exceptions.CustomerExceptions;

public class CustomerAlreadyExistsWithinBankException extends RuntimeException{
    public CustomerAlreadyExistsWithinBankException(String message) {
        super(message);
    }
}
