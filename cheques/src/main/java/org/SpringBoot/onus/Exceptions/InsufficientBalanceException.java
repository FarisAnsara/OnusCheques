package org.SpringBoot.onus.Exceptions;

public class InsufficientBalanceException extends UnsupportedOperationException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
