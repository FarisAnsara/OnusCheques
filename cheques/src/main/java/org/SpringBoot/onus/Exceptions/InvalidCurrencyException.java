package org.SpringBoot.onus.Exceptions;

public class InvalidCurrencyException extends IllegalArgumentException{
    public InvalidCurrencyException(String s) {
        super(s);
    }
}
