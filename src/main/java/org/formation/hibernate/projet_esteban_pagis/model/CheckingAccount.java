package org.formation.hibernate.projet_esteban_pagis.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CK")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CheckingAccount extends Account {

    // feature: autoriser le decouvert...

    public CheckingAccount(String accountNumber, double balance, java.time.LocalDate openDate, Client client) {
        super(null, accountNumber, balance, openDate, client);
    }
}