package org.SpringBoot.onus.Exceptions.ChequeExceptions;

public class ChequeDoesNotExistException extends IllegalArgumentException{
    public ChequeDoesNotExistException(String s) {
        super(s);
    }
}
