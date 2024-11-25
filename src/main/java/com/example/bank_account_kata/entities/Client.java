package com.example.bank_account_kata.entities;

import jakarta.persistence.*;

import java.util.List;


/**
 * J'ai crée cette entité pour représenter le client qui va effectuer une opérations sur son compte
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String telephone;
    private String type;

    /**
     * Le client peut avoir plusieurs comptes bancaires et des différents types aussi.
     */
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CompteBancaire> comptes;

    public Client() {
    }

    public Client(String nom, String telephone, String type) {
        this.nom = nom;
        this.telephone = telephone;
        this.type = type;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CompteBancaire> getComptes() {
        return comptes;
    }

    public void setComptes(List<CompteBancaire> comptes) {
        this.comptes = comptes;
    }

}
