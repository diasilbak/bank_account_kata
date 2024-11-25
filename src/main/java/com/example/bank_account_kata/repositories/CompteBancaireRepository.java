package com.example.bank_account_kata.repositories;

import com.example.bank_account_kata.entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {
}