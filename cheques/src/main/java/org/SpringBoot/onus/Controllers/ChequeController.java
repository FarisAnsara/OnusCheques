package org.SpringBoot.onus.Controllers;

import org.SpringBoot.onus.Models.ChequeModels.CreateChequeRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Repositories.ChequeRepository;
import org.SpringBoot.onus.Repositories.CustomerRepository;
import org.SpringBoot.onus.Services.ChequeServices.ChequeService;
import org.SpringBoot.onus.Services.ChequeServices.ChequeServiceImpl;
import org.SpringBoot.onus.entities.ChequeEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cheques")
public class ChequeController {

    ChequeRepository chequeRepository;
    CustomerRepository customerRepository;
    BranchRepository branchRepository;
    BankRepository bankRepository;
    ChequeService chequeService = new ChequeServiceImpl();

    public ChequeController(ChequeRepository chequeRepository, CustomerRepository customerRepository, BranchRepository branchRepository, BankRepository bankRepository) {
        this.chequeRepository = chequeRepository;
        this.customerRepository = customerRepository;
        this.branchRepository = branchRepository;
        this.bankRepository = bankRepository;
    }

    @GetMapping
    public ResponseEntity<List<ChequeEntity>> getCheques() {
        return ResponseEntity.accepted().body((List<ChequeEntity>) chequeRepository.findAll());
    }

    @PostMapping("/create-cheque-book")
    public ResponseEntity<List<ChequeEntity>> addCheque(@RequestBody CreateChequeRequest createChequeRequest) {
        List<ChequeEntity> createdChequeBook = chequeService.loadChequeBook(createChequeRequest, chequeRepository,customerRepository,branchRepository,bankRepository);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdChequeBook);
    }






}
