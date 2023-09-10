package org.SpringBoot.onus.Exceptions.PayerExceptions;

public class InsufficientBalanceException extends UnsupportedOperationException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
