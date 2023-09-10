package org.SpringBoot.onus.Exceptions.BfdExceptions;

public class BfdAccountIsInvalidException extends IllegalArgumentException{
    public BfdAccountIsInvalidException(String s) {
        super(s);
    }
}
