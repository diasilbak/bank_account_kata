package com.example.bank_account_kata.services;


import com.example.bank_account_kata.entities.Client;
import com.example.bank_account_kata.entities.CompteBancaire;
import com.example.bank_account_kata.entities.CompteCourant;
import com.example.bank_account_kata.repositories.CompteBancaireRepository;
import com.example.bank_account_kata.repositories.OperationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CompteServiceTest {

    @Mock
    private CompteBancaireRepository compteBancaireRepository;

    @Mock
    private OperationRepository operationRepository;

    @InjectMocks
    private CompteService compteService;

    private CompteBancaire compte;

    private static final Long ID_COMPTE_FOR_TEST = 123987L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Création d'un compte bancaire de test
        compte = create_compte_courant();
        when(compteBancaireRepository.findById(anyLong())).thenReturn(Optional.of(compte));
    }


    @Test
    void depot() {

        // given
        compteService.deposer(compte.getId(), 200.0);

        // then
        assertEquals(1200.0, compte.getSolde());
        verify(compteBancaireRepository, times(1)).findById(ID_COMPTE_FOR_TEST);
    }

    @Test
    void retrait() {
        // given, when
        compteService.retirer(compte.getId(), 100.0);

        // then
        assertEquals(900.0, compte.getSolde());
        verify(compteBancaireRepository, times(1)).findById(ID_COMPTE_FOR_TEST);
    }

    @Test
    void retrait_insuffisant() {
        // given, when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            compteService.retirer(compte.getId(), 1001.0);
        });

        // then
        assertEquals("Solde insuffisant pour effectuer ce retrait!", exception.getMessage());
    }


    private CompteCourant create_compte_courant() {
        CompteCourant compte = new CompteCourant();
        compte.setId(ID_COMPTE_FOR_TEST);
        compte.setClient(new Client());
        compte.setSolde(1000L);
        compte.setDateDerniereTransaction(new Date());
        return compte;
    }
}

