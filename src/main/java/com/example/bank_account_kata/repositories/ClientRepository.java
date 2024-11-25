package com.example.bank_account_kata.repositories;


import com.example.bank_account_kata.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}