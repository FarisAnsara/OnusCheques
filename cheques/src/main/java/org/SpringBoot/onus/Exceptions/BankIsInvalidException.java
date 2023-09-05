package org.SpringBoot.onus.Exceptions;

public class BankIsInvalidException extends IllegalArgumentException{
    public BankIsInvalidException(String s) {
        super(s);
    }
}
