package org.SpringBoot.onus.Services.ChequeServices;

import org.SpringBoot.onus.Models.ChequeModels.CreateChequeRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.ChequeRepository;
import org.SpringBoot.onus.Repositories.CustomerRepository;
import org.SpringBoot.onus.entities.ChequeEntity;

import java.util.List;

public interface ChequeService {
    public List<ChequeEntity> loadChequeBook(
            CreateChequeRequest createChequeRequest,
            ChequeRepository chequeRepository,
            CustomerRepository customerRepository,
            BranchRepository branchRepository,
            BankRepository bankRepository);
}
