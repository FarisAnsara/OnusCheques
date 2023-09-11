package org.SpringBoot.onus.Services.CustomerServices;

import org.SpringBoot.onus.Models.CustomerModels.CreateCustomerRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.CustomerRepository;

public interface CustomerService {
    public org.SpringBoot.onus.entities.CustomerEntity loadBranch(
            CreateCustomerRequest createCustomerRequest,
            BankRepository bankRepository,
            BranchRepository branchRepository,
            CustomerRepository customerRepository
    );
}
