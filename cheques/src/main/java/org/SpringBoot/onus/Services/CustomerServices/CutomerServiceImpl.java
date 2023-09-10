package org.SpringBoot.onus.Services.CustomerServices;

import org.SpringBoot.onus.Exceptions.BankExceptions.BankDoesNotExistException;
import org.SpringBoot.onus.Exceptions.CustomerExceptions.CustomerAlreadyExistsWithinBankException;
import org.SpringBoot.onus.Exceptions.CustomerExceptions.NameWithNullValueException;
import org.SpringBoot.onus.Exceptions.CustomerExceptions.NationalIdIsNullException;
import org.SpringBoot.onus.Models.CustomerModels.CreateCustomerRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.CustomerEntityRepository;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.entities.CustomerEntity;

public class CutomerServiceImpl implements CustomerService {
    @Override
    public CustomerEntity loadBranch(CreateCustomerRequest customerRequest, BankRepository bankRepository, BranchRepository branchRepository, CustomerEntityRepository customerEntityRepository) {
        ifAnyOfNameIsNullThrow(customerRequest);
        ifNationalIdNullThrow(customerRequest.getNationalId());
        BankEntity bank = bankRepository.findBankByBankId_Id(customerRequest.getBankId());
        ifBankisNullThenThrow(bank);
        checkIfCustomerExistWithinBank(customerRequest, customerEntityRepository, bank);
        return getCustomerEntity(customerRequest, customerEntityRepository, bank);
    }

    private void ifBankisNullThenThrow(BankEntity bank) {
        if(bank == null){
            throw new BankDoesNotExistException("Bank does not exist");
        }
    }

    private void ifNationalIdNullThrow(long nationalId) {
        if(nationalId == 0){
            throw new NationalIdIsNullException("National Id cannot be zero");
        }
    }

    private static void checkIfCustomerExistWithinBank(CreateCustomerRequest customerRequest, CustomerEntityRepository customerEntityRepository, BankEntity bank) {
        CustomerEntity customer = customerEntityRepository.findByNationalIdAndBank(customerRequest.getNationalId(), bank);
        if(customer != null){
            throw new CustomerAlreadyExistsWithinBankException("Customer already exists within bank");
        }
    }


    private static CustomerEntity getCustomerEntity(CreateCustomerRequest customerRequest, CustomerEntityRepository customerEntityRepository, BankEntity bank) {
        customerRequest.setStatus("Active");
        long accountNumber = GenerateAccountNumber.generate();
        return customerEntityRepository.save(new CustomerEntity(
                customerRequest.getNationalId(),
                accountNumber,
                customerRequest.getFirstName(),
                customerRequest.getFathersName(),
                customerRequest.getGrandFathersName(),
                customerRequest.getLastName(),
                customerRequest.getBalance(),
                customerRequest.getStatus(),
                bank
        ));
    }

    private void ifAnyOfNameIsNullThrow(CreateCustomerRequest customerRequest) {
        if (isAnyOfNameNull(customerRequest))
            throw new NameWithNullValueException("Cannot have any of name variables as null");
    }

    private boolean isAnyOfNameNull(CreateCustomerRequest customerRequest) {
        return customerRequest.getFirstName() == null ||
                customerRequest.getFathersName() == null ||
                customerRequest.getGrandFathersName() == null ||
                customerRequest.getLastName() == null;
    }
}
