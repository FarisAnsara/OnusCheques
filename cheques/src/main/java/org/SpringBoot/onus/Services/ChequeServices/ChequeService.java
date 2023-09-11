package org.SpringBoot.onus.Services.ChequeServices;

import org.SpringBoot.onus.Models.ChequeModels.CreateCashChequeRequest;
import org.SpringBoot.onus.Models.ChequeModels.CreateNewChequeBookRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.ChequeRepository;
import org.SpringBoot.onus.Repositories.CustomerRepository;
import org.SpringBoot.onus.entities.ChequeEntity;
import org.SpringBoot.onus.entities.CustomerEntity;

import java.util.List;

public interface ChequeService {
    public List<ChequeEntity> loadChequeBook(
            CreateNewChequeBookRequest createNewChequeBookRequest,
            ChequeRepository chequeRepository,
            CustomerRepository customerRepository,
            BranchRepository branchRepository,
            BankRepository bankRepository);

    List<CustomerEntity> cashCheque(
            CreateCashChequeRequest createCashChequeRequest,
            ChequeRepository chequeRepository,
            CustomerRepository customerRepository,
            BranchRepository branchRepository,
            BankRepository bankRepository);
}
