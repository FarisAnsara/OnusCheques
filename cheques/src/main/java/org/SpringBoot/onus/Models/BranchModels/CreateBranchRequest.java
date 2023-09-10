package org.SpringBoot.onus.Models.BranchModels;

import java.util.Objects;

public class CreateBranchRequest {

    private long id;
    private String branchName;
    private long bankId;

    public CreateBranchRequest() {
    }

    public CreateBranchRequest(long id, String branchName, long bankId) {
        this.id = id;
        this.branchName = branchName;
        this.bankId = bankId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateBranchRequest that = (CreateBranchRequest) o;
        return id == that.id && bankId == that.bankId && Objects.equals(branchName, that.branchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchName, bankId);
    }

    @Override
    public String toString() {
        return "CreateBranchRequest{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", bankId=" + bankId +
                '}';
    }
}
