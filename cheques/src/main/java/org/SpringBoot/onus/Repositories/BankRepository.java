package org.SpringBoot.onus.Repositories;
import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.Models.BankModels.BankId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<BankEntity, BankId> {
    @Query("SELECT MAX(c.bankId.id) FROM BankEntity c")
    Long findMaxBankID();
    @Query("select c from BankEntity c where c.bankId.name = :name")
    BankEntity findByName(@Param("name") String name);

    BankEntity findBankByBankId_Id(long id);

}
