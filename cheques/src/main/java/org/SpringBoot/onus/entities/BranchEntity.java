package org.SpringBoot.onus.entities;

import jakarta.persistence.*;
import org.SpringBoot.onus.Models.BranchModels.BranchId;

import java.util.Collection;

@Entity
@Table(name = "BRANCHES")
public class BranchEntity {

    @EmbeddedId
    private BranchId branchId;

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                '}';
    }

    public BranchEntity(BranchId branchId) {
        this.branchId = branchId;
    }

    public BranchEntity() {
    }

    public BranchId getBranchId() {
        return branchId;
    }

    public void setBranchId(BranchId branchId) {
        this.branchId = branchId;
    }
}

