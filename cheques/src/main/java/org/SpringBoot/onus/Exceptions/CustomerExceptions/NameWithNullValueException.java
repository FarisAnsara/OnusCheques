package org.SpringBoot.onus.Exceptions.CustomerExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NameWithNullValueException extends IllegalArgumentException{
    public NameWithNullValueException(String s) {
        super(s);
    }
}
