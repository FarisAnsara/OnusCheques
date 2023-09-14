package org.SpringBoot.onus.Services.BankServices;

import org.SpringBoot.onus.Exceptions.BankExceptions.BankAlreadyExistsException;
import org.SpringBoot.onus.Exceptions.BankExceptions.BankIsInvalidException;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.Models.BankModels.BankId;
import org.SpringBoot.onus.Repositories.BankRepository;

public class BankControllerImpl implements BankService{

    @Override
    public BankEntity loadBank(String bankName, BankRepository bankRepository) {
        ifBankNameNullThrow(bankName);
        BankEntity checkBankEntity = bankRepository.findByName(bankName);
        if (checkBankEntity != null)
            throw new BankAlreadyExistsException("Bank already exists");
        return createNewbank(bankRepository, bankName);
    }
    private static void ifBankNameNullThrow(String bankName) {
        if(bankName == null){
            throw new BankIsInvalidException("Bank name cannot be null");
        }
    }

    private static BankEntity createNewbank(BankRepository bankRepository, String bankName) {
        long newId = getNewId(bankRepository);
        return bankRepository.save(new BankEntity(new BankId(newId, bankName)));
    }

    private static long getNewId(BankRepository bankRepository) {
        if (bankRepository.findMaxBankID() != null)
            return bankRepository.findMaxBankID() + 1;
        return 1;
    }



}
