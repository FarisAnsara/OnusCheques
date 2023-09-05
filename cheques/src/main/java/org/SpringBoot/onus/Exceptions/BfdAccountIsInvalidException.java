package org.SpringBoot.onus.Exceptions;

public class BfdAccountIsInvalidException extends IllegalArgumentException{
    public BfdAccountIsInvalidException(String s) {
        super(s);
    }
}
