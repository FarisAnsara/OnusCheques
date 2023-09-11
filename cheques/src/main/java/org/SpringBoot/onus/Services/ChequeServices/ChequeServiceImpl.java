package org.SpringBoot.onus.Services.ChequeServices;

import org.SpringBoot.onus.Exceptions.BankExceptions.BankDoesNotExistException;
import org.SpringBoot.onus.Exceptions.BranchExceptions.BranchIsInvalidException;
import org.SpringBoot.onus.Exceptions.ChequeExceptions.ChequeDoesNotExistException;
import org.SpringBoot.onus.Exceptions.ChequeExceptions.ChequeIsDuplicateException;
import org.SpringBoot.onus.Exceptions.ChequeExceptions.NotAnOnusChequeOperationException;
import org.SpringBoot.onus.Exceptions.CustomerExceptions.CustomerDoesNotExistException;
import org.SpringBoot.onus.Exceptions.CustomerExceptions.CustomerStatusIsNotActive;
import org.SpringBoot.onus.Exceptions.PayerExceptions.InsufficientBalanceException;
import org.SpringBoot.onus.Models.ChequeModels.CreateCashChequeRequest;
import org.SpringBoot.onus.Models.ChequeModels.CreateNewChequeBookRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.ChequeRepository;
import org.SpringBoot.onus.Repositories.CustomerRepository;
import org.SpringBoot.onus.entities.ChequeEntity;
import org.SpringBoot.onus.entities.CustomerEntity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChequeServiceImpl implements ChequeService {

    @Override
    public List<ChequeEntity> loadChequeBook(CreateNewChequeBookRequest createNewChequeBookRequest, ChequeRepository chequeRepository, CustomerRepository customerRepository, BranchRepository branchRepository, BankRepository bankRepository) {
        validateBankExits(createNewChequeBookRequest.getBankId(), bankRepository);
        validateBranchExists(createNewChequeBookRequest.getBranchId(), createNewChequeBookRequest.getBankId(), branchRepository, bankRepository);
        validateAccountExists(createNewChequeBookRequest.getAccountNumber(), createNewChequeBookRequest.getBankId(), customerRepository, bankRepository);
        return getCreatedCheckBook(createNewChequeBookRequest, chequeRepository);
    }

    @Override
    public List<CustomerEntity> cashCheque(CreateCashChequeRequest createCashChequeRequest, ChequeRepository chequeRepository, CustomerRepository customerRepository, BranchRepository branchRepository, BankRepository bankRepository) {
        List<CustomerEntity> customerEntities = new ArrayList<>(4);
        ChequeEntity cheque = getChequeEntity(createCashChequeRequest, chequeRepository);
        validateBankExits(createCashChequeRequest.getBankId(), bankRepository);
        validateBranchExists(createCashChequeRequest.getBranchId(), createCashChequeRequest.getBankId(), branchRepository, bankRepository);
        validateAccountExists(createCashChequeRequest.getAccountNumber(), createCashChequeRequest.getBankId(), customerRepository, bankRepository);
        CustomerEntity bfd = validateOnusCheque(createCashChequeRequest.getBankId(),createCashChequeRequest.getBfdAccountNumber(), customerRepository);
        CustomerEntity payer = validateBalance(createCashChequeRequest.getAmmount(), createCashChequeRequest.getAccountNumber(),customerRepository);
        validateStatus(payer, bfd);
        payer = updatePayerBalance(payer, customerRepository,createCashChequeRequest.getAmmount());
        bfd = updatePayeeBalance(bfd, customerRepository, createCashChequeRequest.getAmmount());
        cheque.setCashed(true);
        chequeRepository.save(cheque);
        customerEntities.add(payer);
        customerEntities.add(bfd);
        return customerEntities;
    }

    private static ChequeEntity getChequeEntity(CreateCashChequeRequest createCashChequeRequest, ChequeRepository chequeRepository) {
        ChequeEntity cheque = chequeRepository.findBySerialNumber(createCashChequeRequest.getSerialNumber());
        if(cheque.isCashed())
            throw new ChequeIsDuplicateException("This cheque has been cashed prior to this data.");
        return cheque;
    }

    private CustomerEntity updatePayeeBalance(CustomerEntity bfd, CustomerRepository customerRepository, float ammount) {
        bfd.setBalance(bfd.getBalance() + ammount);
        customerRepository.save(bfd);
        return bfd;
    }

    private CustomerEntity updatePayerBalance(CustomerEntity payer, CustomerRepository customerRepository, float ammount) {
        payer.setBalance(payer.getBalance() - ammount);
        customerRepository.save(payer);
        return payer;
    }

    private void validateStatus(CustomerEntity payer, CustomerEntity bfd) {
        if(!Objects.equals(payer.getStatus(), "Active"))
            throw new CustomerStatusIsNotActive("Payer account is inactive");
        if(!Objects.equals(bfd.getStatus(), "Active"))
            throw new CustomerStatusIsNotActive("BFD account is inactive");
    }

    private CustomerEntity validateBalance(float ammount, long accountNumber, CustomerRepository customerRepository) {
        CustomerEntity payer = customerRepository.findByAccountNumber(accountNumber);
        if(payer.getBalance() < ammount)
            throw new InsufficientBalanceException("Balance is insufficient to cash this cheque");
        return payer;
    }

    private CustomerEntity validateOnusCheque(long bankId,long accountNumber, CustomerRepository customerRepository) {
        CustomerEntity payee = getPayee(accountNumber, customerRepository);
        if(payee.getBank().getBankId().getId() != bankId)
            throw new NotAnOnusChequeOperationException("Bank's for the payer and payee do not match, NOT an onus cheque");
        return payee;
    }

    private static CustomerEntity getPayee(long accountNumber, CustomerRepository customerRepository) {
        CustomerEntity payee = customerRepository.findByAccountNumber(accountNumber);
        if(payee == null)
            throw new CustomerDoesNotExistException("Payee account does not exist");
        return payee;
    }

    private void validateSerialNumber(String serialNumber, ChequeRepository chequeRepository) {
        if(!chequeRepository.existsBySerialNumber(serialNumber))
            throw new ChequeDoesNotExistException("Cheque serial number is invalid");
    }

    private void validateAccountExists(long accountNumber, long bankId, CustomerRepository customerRepository, BankRepository bankRepository) {
        if (!customerRepository.existsByAccountNumberAndBank_BankId_Id(accountNumber, bankId))
            throw new CustomerDoesNotExistException("Customer with account number " + accountNumber + " does not exist within bank");
    }


    private void validateBranchExists(long branchId, long bankId, BranchRepository branchRepository, BankRepository bankRepository) {
        if (branchRepository.findByBranchId_IdAndBranchId_BankEntity(branchId, bankRepository.findBankByBankId_Id(bankId)) == null)
            throw new BranchIsInvalidException("Branch does not exist");
    }

    private void validateBankExits(long bankId, BankRepository bankRepository) {
        if (!bankRepository.existsByBankId_Id(bankId)) throw new BankDoesNotExistException("Bank does not exist");
    }

    private static List<ChequeEntity> getCreatedCheckBook(CreateNewChequeBookRequest createNewChequeBookRequest, ChequeRepository chequeRepository) {
        DecimalFormat df = new DecimalFormat("000000");
        List<ChequeEntity> createdCheckBook = new ArrayList<>();
        long maxSerial = chequeRepository.findMaxBranchId() == null ? 0 : chequeRepository.findMaxBranchId();
        for (long i = 1; i <= 50; i++) {
            String serialNumber = df.format(maxSerial + i);
            ChequeEntity cheque = new ChequeEntity(serialNumber, createNewChequeBookRequest.getBankId(), createNewChequeBookRequest.getBranchId(), createNewChequeBookRequest.getAccountNumber());
            chequeRepository.save(cheque);
            createdCheckBook.add(cheque);
        }
        return createdCheckBook;
    }

}
