package org.SpringBoot.onus.Exceptions.ChequeExceptions;

public class InvalidCurrencyException extends IllegalArgumentException{
    public InvalidCurrencyException(String s) {
        super(s);
    }
}
