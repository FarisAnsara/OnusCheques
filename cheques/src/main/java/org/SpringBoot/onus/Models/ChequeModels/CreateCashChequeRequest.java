package org.SpringBoot.onus.Models.ChequeModels;

import java.util.Objects;

public class CreateCashChequeRequest {

    private String serialNumber;
    private long bankId;
    private long branchId;
    private long accountNumber;
    private float ammount;
    private long bfdAccountNumber;
    public CreateCashChequeRequest() {
    }

    public CreateCashChequeRequest(String serialNumber, long bankId, long branchId, long accountNumber, float ammount, long bfdAccountNumber) {
        this.serialNumber = serialNumber;
        this.bankId = bankId;
        this.branchId = branchId;
        this.accountNumber = accountNumber;
        this.ammount = ammount;
        this.bfdAccountNumber = bfdAccountNumber;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
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
    public String toString() {
        return "CreateCashChequeRequest{" +
                "serialNumber='" + serialNumber + '\'' +
                ", bankId=" + bankId +
                ", branchId=" + branchId +
                ", accountNumber=" + accountNumber +
                ", ammount=" + ammount +
                '}';
    }

    public long getBfdAccountNumber() {
        return bfdAccountNumber;
    }

    public void setBfdAccountNumber(long bfdAccountNumber) {
        this.bfdAccountNumber = bfdAccountNumber;
    }
}
