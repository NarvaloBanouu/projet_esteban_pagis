package org.formation.hibernate.projet_esteban_pagis.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("SV")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SavingsAccount extends Account {

    // feature: taux d'interessement...

    public SavingsAccount(String accountNumber, double balance, java.time.LocalDate openDate, Client client) {
        super(null, accountNumber, balance, openDate, client);
    }
}