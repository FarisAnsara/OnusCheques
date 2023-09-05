package org.SpringBoot.onus.Services;

import jakarta.persistence.SequenceGenerator;
import org.SpringBoot.onus.Repositories.UserRepository;

public class GenerateAccountNumber{
    public static Long generate(){
        long min = 100_000_000_000_000L;
        long max = 999_999_999_999_999L;
        long randomId = (long) ((Math.random() * (max - min)) + min);
        return randomId;
    }
}