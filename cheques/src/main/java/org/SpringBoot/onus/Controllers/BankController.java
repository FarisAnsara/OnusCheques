package org.SpringBoot.onus.Controllers;

import org.SpringBoot.onus.Exceptions.BankExceptions.BankAlreadyExistsException;
import org.SpringBoot.onus.Exceptions.BankExceptions.BankIsInvalidException;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Services.BankServices.BankControllerImpl;
import org.SpringBoot.onus.Services.BankServices.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins ="*")
@RequestMapping(value = "/bank-post-and-get")
public class BankController {

    private final BankRepository bankRepository;

    private final BankService bankService = new BankControllerImpl();

    public BankController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;}

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<BankEntity>> getBank() {
        return ResponseEntity.accepted().body((List<BankEntity>) bankRepository.findAll());
    }

    @PostMapping()
    public ResponseEntity<BankEntity> addBank(@RequestBody String name) throws BankAlreadyExistsException, BankIsInvalidException {
        BankEntity newBankEntity = bankService.loadBank(name, bankRepository);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBankEntity);
    }

}
