package org.SpringBoot.onus.Exceptions;

public class BranchIsInvalidException extends IllegalArgumentException{
    public BranchIsInvalidException(String s) {
        super(s);
    }
}
