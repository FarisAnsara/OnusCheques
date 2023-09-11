package org.SpringBoot.onus.Repositories;

import org.SpringBoot.onus.Models.BankModels.BankId;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByNationalIdAndBank(long nationalId, BankEntity bank);

    boolean existsByAccountNumberAndBank_BankId_Id(long accountNumber, long bank_bankId_id);


}
