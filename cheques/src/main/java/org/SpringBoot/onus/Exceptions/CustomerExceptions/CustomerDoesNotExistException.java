package org.SpringBoot.onus.Exceptions.CustomerExceptions;

public class CustomerDoesNotExistException extends IllegalArgumentException{
    public CustomerDoesNotExistException(String s) {
        super(s);
    }
}
