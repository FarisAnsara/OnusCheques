package org.SpringBoot.onus.Exceptions;

public class NotAnOnusChequeOperationException extends IllegalArgumentException{
    public NotAnOnusChequeOperationException(String s) {
        super(s);
    }
}
