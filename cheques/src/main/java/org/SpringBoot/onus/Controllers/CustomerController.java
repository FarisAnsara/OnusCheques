package org.SpringBoot.onus.Controllers;

import org.SpringBoot.onus.Exceptions.NameWithNullValueException;
import org.SpringBoot.onus.Models.Customer;
import org.SpringBoot.onus.Repositories.CustomerRepository;
import org.SpringBoot.onus.Services.GenerateAccountNumber;
import org.SpringBoot.onus.Services.CustomerControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CustomerController {

    public CustomerRepository customerRepository;
    CustomerControllerImpl customerControllerImpl = new CustomerControllerImpl();

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addUserTest(Customer customer) {
        Customer createdCustomer = customerRepository.save(customer);
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public ResponseEntity<List<Customer>> getUsers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(u -> customers.add(u));
        return ResponseEntity.ok(customers);
    }

    @PostMapping(value = "post-users")
    public ResponseEntity<Object> addUser(@RequestBody Customer customer) throws NameWithNullValueException {
        customer.setAccountNumber(GenerateAccountNumber.generate());
//        customerControllerImpl.checkNullValueInName(customer);
        if(customerControllerImpl.checkNullValueInName(customer))
            throw new NameWithNullValueException("check all fields have values");
        Customer createdCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(createdCustomer);
    }
}
