package org.SpringBoot.onus.Exceptions;

public class NameWithNullValueException extends IllegalArgumentException{
    public NameWithNullValueException(String s) {
        super(s);
    }
}
