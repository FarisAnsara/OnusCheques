package org.SpringBoot.onus.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CustomerEntity {

    @Id
    private long nationalId;
    private long accountNumber;
    private String firstName;
    private String fathersName;
    private String grandFathersName;
    private String lastName;
    private float balance;
    private String status;
    @ManyToOne
    BankEntity bank;

    public CustomerEntity() {
    }

    public CustomerEntity(long nationalId, long accountNumber, String firstName, String fathersName, String grandFathersName, String lastName, float balance, String status, BankEntity bank) {
        this.nationalId = nationalId;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.grandFathersName = grandFathersName;
        this.lastName = lastName;
        this.balance = balance;
        this.status = status;
        this.bank = bank;
    }

    public long getNationalId() {
        return nationalId;
    }

    public void setNationalId(long nationalId) {
        this.nationalId = nationalId;
    }

    public BankEntity getBank() {
        return bank;
    }

    public void setBank(BankEntity bank) {
        this.bank = bank;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
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

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "nationalId=" + nationalId +
                ", accountNumber=" + accountNumber +
                ", firstName='" + firstName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", grandFathersName='" + grandFathersName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                ", bank=" + bank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity customer = (CustomerEntity) o;
        return nationalId == customer.nationalId && accountNumber == customer.accountNumber && Float.compare(balance, customer.balance) == 0 && Objects.equals(firstName, customer.firstName) && Objects.equals(fathersName, customer.fathersName) && Objects.equals(grandFathersName, customer.grandFathersName) && Objects.equals(lastName, customer.lastName) && Objects.equals(status, customer.status) && Objects.equals(bank, customer.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalId, accountNumber, firstName, fathersName, grandFathersName, lastName, balance, status, bank);
    }

}
