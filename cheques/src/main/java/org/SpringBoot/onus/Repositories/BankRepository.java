package org.SpringBoot.onus.Repositories;
import org.SpringBoot.onus.Models.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {
}
