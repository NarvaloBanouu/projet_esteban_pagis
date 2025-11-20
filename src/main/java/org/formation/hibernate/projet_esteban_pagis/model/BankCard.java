package org.formation.hibernate.projet_esteban_pagis.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private LocalDate issueDate;
    private LocalDate expiryDate;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "checking_account_id")
    private CheckingAccount checkingAccount;
}