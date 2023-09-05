package org.SpringBoot.onus.Exceptions;

public class PayerAccountIsInvalidException extends IllegalArgumentException{
    public PayerAccountIsInvalidException(String s) {
        super(s);
    }
}
