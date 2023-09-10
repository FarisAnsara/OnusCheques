package org.SpringBoot.onus.Models.BankModels;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BankId implements Serializable {

    long id;
    String name;

    public BankId(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BankId() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BankId{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
