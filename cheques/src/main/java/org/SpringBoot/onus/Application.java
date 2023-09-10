package org.SpringBoot.onus;


import org.SpringBoot.onus.Controllers.BankController;
//import org.SpringBoot.onus.Controllers.BranchController;
import org.SpringBoot.onus.Controllers.BranchController;
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
    CommandLineRunner init(CustomerRepository customerRepository, BranchRepository branchRepository , BankRepository bankRepository) {
        CustomerController customerController = new CustomerController(customerRepository);
        BranchController branchController = new BranchController(branchRepository, bankRepository);
        BankController bankController = new BankController(bankRepository);
        Customer user = new Customer("Faris", "Ibrahim", "Daoud", "Ansara");
        Customer user2 = new Customer("Tarik","Ibrahim", "Daoud", "Ansara");
        Set<Customer> customerSet = new HashSet<>();
        customerSet.add(user); customerSet.add(user2);
        BankId bankId= new BankId(0,"HSBC");
        BankId bank2Id = new BankId(0,"Santander");
        BankEntity bankEntity = new BankEntity(bankId);
        BankEntity bankEntity2 = new BankEntity(bank2Id);
        BranchId branchId = new BranchId(0, bankEntity,"London");
        BranchEntity branchEntity = new BranchEntity(branchId);
        return args -> {
//            customerController.addUser(user);
//            customerController.addUser(user2);
//            customerRepository.save(user);
//            customerRepository.save(user2);
            bankController.addBank(bankEntity);
            bankController.addBank(bankEntity2);
//            branchController.addBranch(branchEntity);
        };
    }
}


