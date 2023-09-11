package org.SpringBoot.onus.Services.ChequeServices;

import org.SpringBoot.onus.Exceptions.BankExceptions.BankDoesNotExistException;
import org.SpringBoot.onus.Exceptions.BranchExceptions.BranchIsInvalidException;
import org.SpringBoot.onus.Exceptions.CustomerExceptions.CustomerDoesNotExistException;
import org.SpringBoot.onus.Models.ChequeModels.CreateChequeRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.ChequeRepository;
import org.SpringBoot.onus.Repositories.CustomerRepository;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.entities.ChequeEntity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ChequeServiceImpl implements ChequeService{

    @Override
    public List<ChequeEntity> loadChequeBook(CreateChequeRequest createChequeRequest, ChequeRepository chequeRepository, CustomerRepository customerRepository, BranchRepository branchRepository, BankRepository bankRepository) {
        validateBankExits(createChequeRequest.getBankId(), bankRepository);
        validateBranchExists(createChequeRequest.getBranchId(), createChequeRequest.getBankId() , branchRepository, bankRepository);
        validateAccountExists(createChequeRequest.getAccountNumber(), createChequeRequest.getBankId() ,customerRepository);
        return getCreatedCheckBook(createChequeRequest, chequeRepository);
    }

    private void validateAccountExists(long accountNumber, long bankId, CustomerRepository customerRepository) {
        if(!customerRepository.existsByAccountNumberAndBank_BankId_Id(accountNumber,bankId))
            throw new CustomerDoesNotExistException("Customer with account number " + accountNumber + " does not exist within bank");
    }


    private void validateBranchExists(long branchId, long bankId, BranchRepository branchRepository, BankRepository bankRepository) {
        if(branchRepository.findByBranchId_IdAndBranchId_BankEntity(branchId,bankRepository.findBankByBankId_Id(bankId)) == null)
            throw new BranchIsInvalidException("Branch does not exist");
    }

    private void validateBankExits(long bankId, BankRepository bankRepository) {
        if(!bankRepository.existsByBankId_Id(bankId))
            throw new BankDoesNotExistException("Bank does not exist");
    }

    private static List<ChequeEntity> getCreatedCheckBook(CreateChequeRequest createChequeRequest, ChequeRepository chequeRepository) {
        DecimalFormat df = new DecimalFormat("000000");
        List<ChequeEntity> createdCheckBook = new ArrayList<>();
        long maxSerial = chequeRepository.findMaxBranchId() == null ? 0 : chequeRepository.findMaxBranchId();
        for(long i = 1; i <= 50; i++){
            String serialNumber = df.format( maxSerial+ i);
            ChequeEntity cheque = new ChequeEntity(serialNumber, createChequeRequest.getBankId(), createChequeRequest.getBranchId(), createChequeRequest.getAccountNumber());
            chequeRepository.save(cheque);
            createdCheckBook.add(cheque);
        }
        return createdCheckBook;
    }

}
