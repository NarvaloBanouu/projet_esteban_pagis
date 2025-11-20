package org.formation.hibernate.projet_esteban_pagis.controller;

import org.formation.hibernate.projet_esteban_pagis.model.BankCard;
import org.formation.hibernate.projet_esteban_pagis.model.CardType;
import org.formation.hibernate.projet_esteban_pagis.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class BankCardController {

    @Autowired
    private BankCardService bankCardService;

    @PostMapping
    public ResponseEntity<BankCard> createCard(
            @RequestParam Long checkingAccountId,
            @RequestParam CardType cardType) {
        try {
            BankCard card = bankCardService.createCard(checkingAccountId, cardType);
            return new ResponseEntity<>(card, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateCard(@PathVariable Long id) {
        try {
            bankCardService.deactivateCard(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}