package org.SpringBoot.onus.Exceptions.BankExceptions;

public class BankDoesNotExistException extends IllegalArgumentException{
    public BankDoesNotExistException(String s) {
        super(s);
    }
}
