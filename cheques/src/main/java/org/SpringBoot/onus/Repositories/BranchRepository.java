package org.SpringBoot.onus.Repositories;

import org.SpringBoot.onus.entities.BankEntity;
import org.SpringBoot.onus.entities.BranchEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<BranchEntity, Long> {
    @Query("SELECT MAX(c.branchId.id) from BranchEntity c")
    Long findMaxBranchId();

//    @Query("SELECT c from BranchEntity c where c.branchId.id = :id and c.branchId.bankEntity = :bankEntity")
    long countBranchEntitiesByBranchId_BankEntity(BankEntity branchId_bankEntity);

    boolean existsBranchEntitiesByBranchId_BranchNameAndBranchId_BankEntity(String branchId_branchName, BankEntity branchId_bankEntity);

    BranchEntity findByBranchId_IdAndBranchId_BankEntity(long branchId_id, BankEntity branchId_bankEntity);
}
