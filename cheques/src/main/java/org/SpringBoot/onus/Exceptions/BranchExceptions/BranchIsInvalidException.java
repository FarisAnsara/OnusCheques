package org.SpringBoot.onus.Exceptions.BranchExceptions;

public class BranchIsInvalidException extends IllegalArgumentException{
    public BranchIsInvalidException(String s) {
        super(s);
    }
}
