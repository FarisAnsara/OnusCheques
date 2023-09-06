package org.SpringBoot.onus.Services;

import org.SpringBoot.onus.Exceptions.NameWithNullValueException;
import org.SpringBoot.onus.Models.Customer;
import org.springframework.web.bind.annotation.ControllerAdvice;

public class CustomerControllerImpl {

    public boolean checkNullValueInName(Customer customer) {
        return customer.getLastName() == null ||
                customer.getGrandFathersName() == null ||
                customer.getFathersName() == null ||
                customer.getFirstName() == null;
    }
//
//    public void checkNullValueInName(Customer customer){
//        checkIfFirstNameNull(customer);
//        checkIfFathersNameNull(customer);
//        checkIfGrandFathersNameNull(customer);
//        checkIfLastNameNull(customer);
//    }
//
//    private void checkIfLastNameNull(Customer customer) {
//        if (customer.getLastName() == null)
//            throw new NameWithNullValueException("Cannot have last name empty");
//    }
//
//    private void checkIfGrandFathersNameNull(Customer customer) {
//        if (customer.getGrandFathersName() == null)
//            throw new NameWithNullValueException("Cannot have grand-father's name empty");
//    }
//
//    private void checkIfFathersNameNull(Customer customer) {
//        if (customer.getFathersName() == null)
//            throw new NameWithNullValueException("Cannot have father's name empty");
//    }
//
//    private void checkIfFirstNameNull(Customer customer) {
//        if (customer.getFirstName() == null)
//            throw new NameWithNullValueException("Cannot have first name empty");
//    }

}
