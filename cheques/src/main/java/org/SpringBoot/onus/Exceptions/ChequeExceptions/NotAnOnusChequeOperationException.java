package org.SpringBoot.onus.Exceptions.ChequeExceptions;

public class NotAnOnusChequeOperationException extends IllegalArgumentException{
    public NotAnOnusChequeOperationException(String s) {
        super(s);
    }
}
