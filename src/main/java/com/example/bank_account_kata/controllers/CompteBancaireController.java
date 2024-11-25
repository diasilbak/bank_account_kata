package com.example.bank_account_kata.controllers;

import com.example.bank_account_kata.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/compte")
public class CompteBancaireController {


    @Autowired
    private CompteService compteService;


    @PostMapping("/{idCompte}/deposer")
    public ResponseEntity<Void> deposer(@PathVariable Long compteId, @RequestParam double montant) {
        try {
            compteService.deposer(compteId, montant);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{idCompte}/retirer")
    public ResponseEntity<Void> retirer(@PathVariable Long compteId, @RequestParam double montant) {
        try {
            compteService.retirer(compteId, montant);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

