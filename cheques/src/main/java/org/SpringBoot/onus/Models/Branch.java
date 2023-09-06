package org.SpringBoot.onus.Models;

import jakarta.persistence.*;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long branchId;
    private String area;
    @ManyToOne
    Customer customer;

    public Branch() {
    }

    public Branch(long branchId, Customer customer) {
        this.branchId = branchId;
        this.customer = customer;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", customer=" + customer +
                '}';
    }
}
