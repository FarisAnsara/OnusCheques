package org.SpringBoot.onus.Models;

import jakarta.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bankId;
    private String bankName;
    @ManyToOne
    private Branch branch;
    @ManyToOne
    private Customer customer;

    public Bank() {
    }

    public Bank(long bankId, Branch branch, Customer customer) {
        this.bankId = bankId;
        this.branch = branch;
        this.customer = customer;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankId=" + bankId +
                ", branch=" + branch +
                ", customer=" + customer +
                '}';
    }
}
