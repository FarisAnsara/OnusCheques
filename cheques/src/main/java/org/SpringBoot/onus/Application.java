package org.SpringBoot.onus;


import org.SpringBoot.onus.Controllers.BankController;
//import org.SpringBoot.onus.Controllers.BranchController;
import org.SpringBoot.onus.Controllers.BranchController;
import org.SpringBoot.onus.Controllers.CustomerController;
import org.SpringBoot.onus.Models.BranchModels.CreateBranchRequest;
import org.SpringBoot.onus.Models.CustomerModels.CreateCustomerRequest;
import org.SpringBoot.onus.Repositories.CustomerRepository;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.Models.BankModels.BankId;
import org.SpringBoot.onus.entities.BranchEntity;
import org.SpringBoot.onus.Models.BranchModels.BranchId;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("org.SpringBoot")
@EntityScan(basePackages = "org.SpringBoot.onus")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(BranchRepository branchRepository , BankRepository bankRepository, CustomerRepository customerRepository) {
        BranchController branchController = new BranchController(branchRepository, bankRepository);
        CustomerController customerController = new CustomerController(customerRepository, branchRepository, bankRepository);
        BankController bankController = new BankController(bankRepository);
        BankId bankId= new BankId(0,"HSBC");
        BankId bank2Id = new BankId(0,"Santander");
        BankEntity bankEntity = new BankEntity(bankId);
        BankEntity bankEntity2 = new BankEntity(bank2Id);
        CreateBranchRequest branchId = new CreateBranchRequest(1,"London",1);
        CreateCustomerRequest customerRequest1 = new CreateCustomerRequest(2000000221, "Tarik", "Ibrahim", "Daoud", "Ansara", 250, "Active", 1);
        CreateCustomerRequest customerRequest2 = new CreateCustomerRequest(2000000121, "Faris", "Ibrahim", "Daoud", "Ansara", 250, "Active", 1);
        return args -> {
//            customerController.addUser(user);
//            customerController.addUser(user2);
//            customerRepository.save(user);
//            customerRepository.save(user2);
            bankController.addBank(bankEntity);
            bankController.addBank(bankEntity2);
            branchController.addBranch(branchId);
            customerController.addCustomer(customerRequest1);
            customerController.addCustomer(customerRequest2);
        };
    }
}


