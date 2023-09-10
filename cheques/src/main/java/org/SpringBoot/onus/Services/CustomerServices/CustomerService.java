package org.SpringBoot.onus.Services.CustomerServices;

import org.SpringBoot.onus.Models.CustomerModels.CreateCustomerRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.CustomerEntityRepository;
import org.SpringBoot.onus.entities.CustomerEntity;

public interface CustomerService {
    public CustomerEntity loadBranch(
            CreateCustomerRequest createCustomerRequest,
            BankRepository bankRepository,
            BranchRepository branchRepository,
            CustomerEntityRepository customerEntityRepository
    );
}
