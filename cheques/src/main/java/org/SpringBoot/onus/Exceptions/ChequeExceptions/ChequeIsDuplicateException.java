package org.SpringBoot.onus.Exceptions.ChequeExceptions;

public class ChequeIsDuplicateException extends IllegalArgumentException{
    public ChequeIsDuplicateException(String s) {
        super(s);
    }
}
