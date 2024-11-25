package com.example.bank_account_kata.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RETRAIT")
public class Retrait extends Operation {
}
