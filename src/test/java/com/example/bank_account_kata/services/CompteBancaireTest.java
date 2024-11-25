package com.example.bank_account_kata.services;


import com.example.bank_account_kata.entities.CompteBancaire;
import com.example.bank_account_kata.entities.CompteCourant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteBancaireTest {

    private CompteBancaire compte;

    @BeforeEach
    void setUp() {
        // Création d'un compte bancaire avec un solde initial de 0
        compte = new CompteCourant();
    }

    @Test
    void deposer() {
        // given, when
        compte.deposerMontant(100.0);

        // then
        assertEquals(100.0, compte.getSolde());
    }

    @Test
    void retirer() {
        // given
        compte.deposerMontant(200.0);

        // when
        compte.retirerMontant(100.0);

        // then
        assertEquals(100.0, compte.getSolde());
    }

    @Test
    void retirer_solde_insuffisant() {
        // given
        compte.deposerMontant(50.0);

        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> compte.retirerMontant(100.0));


        //then
        assertEquals("Solde insuffisant pour effectuer ce retrait!", exception.getMessage());
    }

    @Test
    void deposer_montant_negatif() {
        // given, when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> compte.deposerMontant(-120.0));

        //then
        assertEquals("Le montant doit être positif!", exception.getMessage());
    }

    @Test
    void retirer_montant_negatif() {
        // given, when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> compte.retirerMontant(-140.0));

        //then
        assertEquals("Le montant deamndé doit être positif!", exception.getMessage());
    }
}
