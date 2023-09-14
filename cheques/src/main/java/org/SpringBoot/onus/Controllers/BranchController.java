package org.SpringBoot.onus.Controllers;

import org.SpringBoot.onus.entities.BranchEntity;
import org.SpringBoot.onus.Models.BranchModels.CreateBranchRequest;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Services.branch.services.BranchService;
import org.SpringBoot.onus.Services.branch.services.BranchServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins ="*")
@RequestMapping(value = "/branches-post-and-get")
public class BranchController {

    private final BranchRepository branchRepository;
    private final BankRepository bankRepository;
    private final BranchService branchService = new BranchServiceImpl();

    public BranchController(BranchRepository branchRepository, BankRepository bankRepository) {
        this.branchRepository = branchRepository;
        this.bankRepository = bankRepository;
    }

    @GetMapping()
    public ResponseEntity<List<BranchEntity>> getBranch() {
        return ResponseEntity.accepted().body((List<BranchEntity>) branchRepository.findAll());
    }

    @PostMapping()
    public ResponseEntity<BranchEntity> addBranch(@RequestBody CreateBranchRequest branchRequest) {
        BranchEntity createdBranchEntity = branchService.loadBranch(branchRequest, bankRepository, branchRepository);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBranchEntity);
    }




}
