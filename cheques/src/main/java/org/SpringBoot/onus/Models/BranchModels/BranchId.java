package org.SpringBoot.onus.Models.BranchModels;

import jakarta.persistence.*;
import org.SpringBoot.onus.entities.BankEntity;

import java.io.Serializable;

@Embeddable
public class BranchId implements Serializable {

    long id;
    String branchName;
    @ManyToOne
    BankEntity bankEntity;

    public BranchId(long id, BankEntity bankEntity, String name) {
        this.id = id;
        this.bankEntity = bankEntity;
        this.branchName = name;
    }

    @Override
    public String toString() {
        return "BranchId{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", bank=" + bankEntity +
                '}';
    }

    public BranchId() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BankEntity getBank() {
        return bankEntity;
    }

    public void setBank(String bankName) {
        this.bankEntity = bankEntity;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String area) {
        this.branchName = area;
    }
}
