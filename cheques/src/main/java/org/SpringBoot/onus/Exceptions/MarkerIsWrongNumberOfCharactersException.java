package org.SpringBoot.onus.Exceptions;

public class MarkerIsWrongNumberOfCharactersException extends IllegalArgumentException{
    public MarkerIsWrongNumberOfCharactersException(String s) {
        super(s);
    }
}
