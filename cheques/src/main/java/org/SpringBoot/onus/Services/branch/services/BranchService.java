package org.SpringBoot.onus.Services.branch.services;

import org.SpringBoot.onus.entities.BranchEntity;
import org.SpringBoot.onus.Models.BranchModels.CreateBranchRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;

public interface BranchService {

    public BranchEntity loadBranch(CreateBranchRequest branchRequest, BankRepository bankRepository, BranchRepository branchRepository);
}
