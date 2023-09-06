package org.SpringBoot.onus.Models;

import jakarta.persistence.*;
import org.SpringBoot.onus.Services.GenerateAccountNumber;

@Entity
//@SequenceGenerator(name = "seq",initialValue = 100,allocationSize = 1000)
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long accountNumber;
    private String firstName;
    private String fathersName;
    private String grandFathersName;
    private String lastName;
    @Column(name = "balance")
    private float balance;
    @Column(name = "status")
    private String status;

    @Override
    public String toString() {
        return "User{" +
                "accountNumber=" + accountNumber +
//                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                '}';
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }


    public Customer() {
    }

    public Customer(String firstName, String fathersName, String grandFathersName, String lastName) {
        this.accountNumber = new GenerateAccountNumber().generate();
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.grandFathersName = grandFathersName;
        this.lastName = lastName;
        this.balance = 0;
        this.status = "Active";
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

}
