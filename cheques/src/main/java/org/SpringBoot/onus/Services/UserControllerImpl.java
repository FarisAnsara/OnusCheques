package org.SpringBoot.onus.Services;

import org.SpringBoot.onus.Exceptions.NameWithNullValueException;
import org.SpringBoot.onus.Models.Customer;
import org.springframework.http.ResponseEntity;

public class UserControllerImpl {

    public void checkNullValueInName(Customer customer) {
        checkIfFirstNameNull(customer);
        checkIfFathersNameNull(customer);
        checkIfGrandFathersNameNull(customer);
        checkIfLastNameNull(customer);
    }

    private void checkIfLastNameNull(Customer customer) {
        if (customer.getLastName() == null)
            throw new NameWithNullValueException("Cannot have last name empty");
    }

    private void checkIfGrandFathersNameNull(Customer customer) {
        if (customer.getLastName() == null)
            throw new NameWithNullValueException("Cannot have grand-father's name empty");
    }

    private void checkIfFathersNameNull(Customer customer) {
        if (customer.getLastName() == null)
            throw new NameWithNullValueException("Cannot have father's name empty");
    }

    private void checkIfFirstNameNull(Customer customer) {
        if (customer.getLastName() == null)
            throw new NameWithNullValueException("Cannot have first name empty");

    }

}
