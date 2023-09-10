package org.SpringBoot.onus.Exceptions.PayerExceptions;

public class PayerAccountIsInvalidException extends IllegalArgumentException{
    public PayerAccountIsInvalidException(String s) {
        super(s);
    }
}
