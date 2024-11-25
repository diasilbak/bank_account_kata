package com.example.bank_account_kata.services;


import com.example.bank_account_kata.entities.CompteBancaire;
import com.example.bank_account_kata.entities.Retrait;
import com.example.bank_account_kata.entities.Versement;
import com.example.bank_account_kata.repositories.CompteBancaireRepository;
import com.example.bank_account_kata.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompteService {

    @Autowired
    private CompteBancaireRepository compteBancaireRepository;

    @Autowired
    private OperationRepository operationRepository;

    /**
     * Méthode pour déposer de l'argent
     *
     * @param compteId
     * @param montant
     */
    public void deposer(Long compteId, double montant) {
        final CompteBancaire compte = getCompteBancaire(compteId);
        compte.deposerMontant(montant);
        versementOperation(compte, montant);
        compteBancaireRepository.save(compte);
    }

    private CompteBancaire getCompteBancaire(Long compteId) {
        return compteBancaireRepository.findById(compteId).orElseThrow(() -> new IllegalArgumentException("Compte non trouvé"));
    }

    // Méthode pour retirer de l'argent
    public void retirer(Long compteId, double montant) {
        final CompteBancaire compte = getCompteBancaire(compteId);
        compte.retirerMontant(montant);
        retraitOperation(compte, montant);
        compteBancaireRepository.save(compte);
    }

    // Créer une opération de type Versement pour tracer l'opération de versement
    private void versementOperation(CompteBancaire compte, double montant) {
        final Versement versement = new Versement();
        versement.setMontant(montant);
        versement.setCompte(compte);
        versement.setDateOperation(new Date());
        operationRepository.save(versement);
    }

    // Créer une opération de type Retrait pour tracer l'operation du retrait
    private void retraitOperation(CompteBancaire compte, double montant) {
        final Retrait retrait = new Retrait();
        retrait.setMontant(montant);
        retrait.setCompte(compte);
        retrait.setDateOperation(new Date());
        operationRepository.save(retrait);
    }

}
