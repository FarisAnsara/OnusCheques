package org.SpringBoot.onus.Repositories;

import org.SpringBoot.onus.Models.BankModels.BankId;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.entities.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByNationalIdAndBank(long nationalId, BankEntity bank);

    boolean existsByAccountNumberAndBank_BankId_Id(long accountNumber, long bank_bankId_id);

    CustomerEntity findByFirstNameAndFathersNameAndGrandFathersNameAndLastName(String firstName, String fathersName, String grandFathersName, String lastName);

    CustomerEntity findByAccountNumber(long accountNumber);

    @Query("update CustomerEntity c set c.balance = :balance where c = :customer")
    void updateBalance(@Param(value = "balance") long balance, @Param("customer") CustomerEntity customer);
}
