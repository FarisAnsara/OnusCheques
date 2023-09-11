package org.SpringBoot.onus.Exceptions.CustomerExceptions;

public class CustomerStatusIsNotActive extends IllegalArgumentException {
    public CustomerStatusIsNotActive(String s) {
        super(s);
    }
}
