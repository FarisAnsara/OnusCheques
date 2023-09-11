package org.SpringBoot.onus.Controllers;

import org.SpringBoot.onus.Models.CustomerModels.CreateCustomerRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.CustomerRepository;
import org.SpringBoot.onus.Services.CustomerServices.CustomerService;
import org.SpringBoot.onus.Services.CustomerServices.CutomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    CustomerRepository customerRepository;
    BranchRepository branchRepository;
    BankRepository bankRepository;
    CustomerService customerService = new CutomerServiceImpl();

    public CustomerController(CustomerRepository customerRepository, BranchRepository branchRepository, BankRepository bankRepository) {
        this.customerRepository = customerRepository;
        this.branchRepository = branchRepository;
        this.bankRepository = bankRepository;

    }

    @GetMapping
    public ResponseEntity<List<org.SpringBoot.onus.entities.CustomerEntity>> getCustomers() {
        return ResponseEntity.accepted().body((List<org.SpringBoot.onus.entities.CustomerEntity>) customerRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<org.SpringBoot.onus.entities.CustomerEntity> addCustomer(@RequestBody CreateCustomerRequest customerRequest){
        org.SpringBoot.onus.entities.CustomerEntity createdCustomerEntity = customerService.loadBranch(customerRequest, bankRepository, branchRepository, customerRepository);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerEntity);
    }

}
