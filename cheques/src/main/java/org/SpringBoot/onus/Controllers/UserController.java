package org.SpringBoot.onus.Controllers;

import org.SpringBoot.onus.Models.Customer;
import org.SpringBoot.onus.Repositories.UserRepository;
import org.SpringBoot.onus.Services.GenerateAccountNumber;
import org.SpringBoot.onus.Services.UserControllerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Controller
public class UserController {

    public UserRepository userRepository;
    UserControllerImpl userControllerImpl = new UserControllerImpl();

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUserTest(Customer customer) {
        Customer createdCustomer = userRepository.save(customer);
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public ResponseEntity<List<Customer>> getUsers() {
        List<Customer> customers = new ArrayList<>();
        userRepository.findAll().forEach(u -> customers.add(u));
        return ResponseEntity.ok(customers);
    }

    @PostMapping(value = "post-users")
    public ResponseEntity<Object> addUser(@RequestBody Customer customer) {
        customer.setAccountNumber(GenerateAccountNumber.generate());
        userControllerImpl.checkNullValueInName(customer);
        Customer createdCustomer = userRepository.save(customer);
        return ResponseEntity.ok(createdCustomer);
    }
}
