package org.SpringBoot.onus.Exceptions;

public class ChequeIsDuplicateException extends IllegalArgumentException{
    public ChequeIsDuplicateException(String s) {
        super(s);
    }
}
