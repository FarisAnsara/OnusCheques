package org.SpringBoot.onus.entities;

import jakarta.persistence.*;
import org.SpringBoot.onus.Models.BankModels.BankId;

@Entity
public class BankEntity {

    @Id
    @EmbeddedId
    private BankId bankId;

    public BankEntity() {
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankId=" + bankId +
                '}';
    }

    public BankId getBankId() {
        return bankId;
    }

    public void setBankId(BankId bankId) {
        this.bankId = bankId;
    }

    public BankEntity(BankId bankId) {
        this.bankId = bankId;
    }


}
