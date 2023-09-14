package org.SpringBoot.onus.Services.BankServices;

import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.Repositories.BankRepository;

public interface BankService {
    public BankEntity loadBank(String bankName, BankRepository bankRepository);
}

