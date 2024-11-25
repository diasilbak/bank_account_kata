package com.example.bank_account_kata.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VERSEMENT")
public class Versement extends Operation {
}
