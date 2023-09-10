package org.SpringBoot.onus.Models.CustomerModels;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.SpringBoot.onus.entities.BranchEntity;

import java.util.Objects;

public class CreateCustomerRequest {

    private long nationalId;
    private String firstName;
    private String fathersName;
    private String grandFathersName;
    private String lastName;
    private float balance;
    private String status;
    long bankId;
    public CreateCustomerRequest() {
    }

    public CreateCustomerRequest(long nationalId, String firstName, String fathersName, String grandFathersName, String lastName, float balance, String status, long bankId) {
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.grandFathersName = grandFathersName;
        this.lastName = lastName;
        this.balance = balance;
        this.status = status;
        this.bankId = bankId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getGrandFathersName() {
        return grandFathersName;
    }

    public void setGrandFathersName(String grandFathersName) {
        this.grandFathersName = grandFathersName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "CreateCustomerRequest{" +
                "nationalId=" + nationalId +
                ", firstName='" + firstName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", grandFathersName='" + grandFathersName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                ", bankId=" + bankId +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCustomerRequest that = (CreateCustomerRequest) o;
        return nationalId == that.nationalId && Float.compare(balance, that.balance) == 0 && bankId == that.bankId && Objects.equals(firstName, that.firstName) && Objects.equals(fathersName, that.fathersName) && Objects.equals(grandFathersName, that.grandFathersName) && Objects.equals(lastName, that.lastName) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalId, firstName, fathersName, grandFathersName, lastName, balance, status, bankId);
    }

    public long getNationalId() {
        return nationalId;
    }

    public void setNationalId(long nationalId) {
        this.nationalId = nationalId;
    }

}
