package com.example.bank_account_kata.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class CompteBancaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Le propriétaire du compte
     */
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    private double solde;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDerniereTransaction;

    public CompteBancaire() {
        // Le constructeur par défaut, par contre on peut créer un contructeur avec d'autres paramétres comme le client, le solde initiale ...
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateDerniereTransaction() {
        return dateDerniereTransaction;
    }

    public void setDateDerniereTransaction(Date dateDerniereTransaction) {
        this.dateDerniereTransaction = dateDerniereTransaction;
    }

    /**
     * Méthode pour déposer de l'argent sue le compte
     */
    public void deposerMontant(double montant) {
        if (montant > 0) {
            this.solde += montant;
        } else {
            throw new IllegalArgumentException("Le montant doit être positif!");
        }
    }

    /**
     * Méthode pour retirer l'argent du compte
     *
     * @param montant
     */
    public void retirerMontant(double montant) {
        if (montant > 0 && this.solde >= montant) {
            this.solde -= montant;
        } else if (montant <= 0) {
            throw new IllegalArgumentException("Le montant deamndé doit être positif!");
        } else {
            throw new IllegalArgumentException("Solde insuffisant pour effectuer ce retrait!");
        }
    }

}
