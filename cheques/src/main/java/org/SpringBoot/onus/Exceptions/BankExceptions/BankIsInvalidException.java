package org.SpringBoot.onus.Exceptions.BankExceptions;

public class BankIsInvalidException extends IllegalArgumentException{
    public BankIsInvalidException(String s) {
        super(s);
    }
}
