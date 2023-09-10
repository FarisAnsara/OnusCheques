package org.SpringBoot.onus.Services.branch.services;

import org.SpringBoot.onus.Exceptions.BankExceptions.BankIsInvalidException;
import org.SpringBoot.onus.Exceptions.BranchExceptions.BranchIsInvalidException;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.entities.BranchEntity;
import org.SpringBoot.onus.Models.BranchModels.BranchId;
import org.SpringBoot.onus.Models.BranchModels.CreateBranchRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;

public class BranchServiceImpl implements BranchService{

    @Override
    public BranchEntity loadBranch(CreateBranchRequest branchRequest, BankRepository bankRepository, BranchRepository branchRepository) {
        ifBranchNameNullThrow(branchRequest);
        BankEntity checkBankEntity = checkBankExistIfNotThrow(branchRequest, bankRepository);
        ifBranchExistsThrow(branchRequest, branchRepository, bankRepository);
        long val = getBranchesForBank(checkBankEntity,branchRepository);
        return branchRepository.save(new BranchEntity(new BranchId(val,
                checkBankEntity,
                branchRequest.getBranchName())));
    }

    private static void ifBranchExistsThrow(CreateBranchRequest branchRequest, BranchRepository branchRepository, BankRepository bankRepository) {
        BankEntity bankEntity = bankRepository.findBankByBankId_Id(branchRequest.getBankId());
        if(branchRepository.existsBranchEntitiesByBranchId_BranchNameAndBranchId_BankEntity(branchRequest.getBranchName(), bankEntity) ){
            throw new BranchIsInvalidException("Branch already exists");
        }
    }

    private static BankEntity checkBankExistIfNotThrow(CreateBranchRequest branchRequest, BankRepository bankRepository) {
        BankEntity checkBankEntity = bankRepository.findBankByBankId_Id(branchRequest.getBankId());
        if (checkBankEntity == null) {
            throw new BankIsInvalidException("Bank does not exist");
        }
        return checkBankEntity;
    }

    private void ifBranchNameNullThrow(CreateBranchRequest branchRequest) {
        String branchName = branchRequest.getBranchName();
        if(branchName == null){
            throw new BranchIsInvalidException("Cannot have branch name as null");
        }
    }


    private long getBranchesForBank(BankEntity bankEntity, BranchRepository branchRepository) {
        if(branchRepository.countBranchEntitiesByBranchId_BankEntity(bankEntity) != 0)
            return branchRepository.countBranchEntitiesByBranchId_BankEntity(bankEntity) + 1;
        return 1;
    }
}
