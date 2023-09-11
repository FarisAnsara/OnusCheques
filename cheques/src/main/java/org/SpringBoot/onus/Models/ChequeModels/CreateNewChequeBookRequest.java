package org.SpringBoot.onus.Models.ChequeModels;

public class CreateNewChequeBookRequest {

    private long bankId;
    private long branchId;
    private long accountNumber;

    public CreateNewChequeBookRequest() {
    }

    public CreateNewChequeBookRequest(String serialNumber, long bankId, long branchId, long accountNumber) {
        this.bankId = bankId;
        this.branchId = branchId;
        this.accountNumber = accountNumber;
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
        return "ChequeEntity{" +
                ", bankId=" + bankId +
                ", branchId=" + branchId +
                ", accountNumber=" + accountNumber +
                '}';
    }

}
