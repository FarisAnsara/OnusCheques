package org.SpringBoot.onus.Repositories;

import org.SpringBoot.onus.Models.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
}
