package org.SpringBoot.onus.Services.CustomerServices;

public class CustomerControllerImpl {

    public boolean checkNullValueInName(Customer customer) {
        return customer.getLastName() == null ||
                customer.getGrandFathersName() == null ||
                customer.getFathersName() == null ||
                customer.getFirstName() == null;
    }

}
