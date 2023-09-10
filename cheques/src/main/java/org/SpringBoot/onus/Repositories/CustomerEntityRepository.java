package org.SpringBoot.onus.Repositories;

import org.SpringBoot.onus.Services.CustomerServices.CustomerService;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.entities.BranchEntity;
import org.SpringBoot.onus.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerEntityRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByNationalIdAndBank(long nationalId, BankEntity bank);

}
