package org.SpringBoot.onus.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class ChequeEntity {

    @Id
    private String serialNumber;
    private long bankId;
    private long branchId;
    private long accountNumber;

    public ChequeEntity() {
    }

    public ChequeEntity(String serialNumber, long bankId, long branchId, long accountNumber) {
        this.serialNumber = serialNumber;
        this.bankId = bankId;
        this.branchId = branchId;
        this.accountNumber = accountNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChequeEntity that = (ChequeEntity) o;
        return serialNumber == that.serialNumber && bankId == that.bankId && branchId == that.branchId && accountNumber == that.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, bankId, branchId, accountNumber);
    }

    @Override
    public String toString() {
        return "ChequeEntity{" +
                "serialNumber=" + serialNumber +
                ", bankId=" + bankId +
                ", branchId=" + branchId +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
