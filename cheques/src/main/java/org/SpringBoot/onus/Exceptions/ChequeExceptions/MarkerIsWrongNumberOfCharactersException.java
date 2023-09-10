package org.SpringBoot.onus.Exceptions.ChequeExceptions;

public class MarkerIsWrongNumberOfCharactersException extends IllegalArgumentException{
    public MarkerIsWrongNumberOfCharactersException(String s) {
        super(s);
    }
}
