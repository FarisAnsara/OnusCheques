package org.SpringBoot.onus.Controllers;

import org.SpringBoot.onus.Models.CustomerModels.CreateCustomerRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.CustomerEntityRepository;
import org.SpringBoot.onus.Services.CustomerServices.CustomerService;
import org.SpringBoot.onus.Services.CustomerServices.CutomerServiceImpl;
import org.SpringBoot.onus.entities.CustomerEntity;
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
public class CustomerEntityController {

    CustomerEntityRepository customerEntityRepository;
    BranchRepository branchRepository;
    BankRepository bankRepository;
    CustomerService customerService = new CutomerServiceImpl();

    public CustomerEntityController(CustomerEntityRepository customerEntityRepository, BranchRepository branchRepository, BankRepository bankRepository) {
        this.customerEntityRepository = customerEntityRepository;
        this.branchRepository = branchRepository;
        this.bankRepository = bankRepository;

    }

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getCustomers() {
        return ResponseEntity.accepted().body((List<CustomerEntity>) customerEntityRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CreateCustomerRequest customerRequest){
        CustomerEntity createdCustomerEntity = customerService.loadBranch(customerRequest, bankRepository, branchRepository, customerEntityRepository);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerEntity);
    }

}
