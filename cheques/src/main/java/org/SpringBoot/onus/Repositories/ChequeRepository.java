package org.SpringBoot.onus.Repositories;

import org.SpringBoot.onus.entities.ChequeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ChequeRepository extends CrudRepository<ChequeEntity, Long> {

    @Query("SELECT MAX(cast(c.serialNumber as long)) from ChequeEntity c")
    Long findMaxBranchId();

}
