package org.SpringBoot.onus.Exceptions.CustomerExceptions;

import jakarta.persistence.Id;

public class NationalIdIsNullException extends IllegalArgumentException {
    public NationalIdIsNullException(String s) {
        super(s);
    }
}
