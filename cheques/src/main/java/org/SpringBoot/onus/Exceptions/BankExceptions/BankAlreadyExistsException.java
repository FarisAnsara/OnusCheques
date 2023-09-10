package org.SpringBoot.onus.Exceptions.BankExceptions;


public class BankAlreadyExistsException extends IllegalArgumentException {
    public BankAlreadyExistsException(String s) {
        super(s);
    }
}
