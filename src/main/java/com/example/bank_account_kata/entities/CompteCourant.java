package com.example.bank_account_kata.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends CompteBancaire {
    private double decouvert;

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    // retrait à redéfinir prenat en compte le découvert

}
