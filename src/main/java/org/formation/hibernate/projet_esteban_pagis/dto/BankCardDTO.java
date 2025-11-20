package org.formation.hibernate.projet_esteban_pagis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.formation.hibernate.projet_esteban_pagis.model.CardType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankCardDTO {
    private Long id;
    private String cardNumber;
    private CardType cardType;
    private boolean active;
}