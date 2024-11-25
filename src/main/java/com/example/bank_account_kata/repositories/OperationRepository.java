package com.example.bank_account_kata.repositories;


import com.example.bank_account_kata.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}