package org.formation.hibernate.projet_esteban_pagis.controller;

import org.formation.hibernate.projet_esteban_pagis.model.Account;
import org.formation.hibernate.projet_esteban_pagis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/client/{clientId}")
    public List<Account> getAccountsByClient(@PathVariable Long clientId) {
        return accountService.findAccountsByClient(clientId);
    }

    @PostMapping("/checking")
    public ResponseEntity<Account> createCheckingAccount(
            @RequestParam Long clientId,
            @RequestParam String accountNumber,
            @RequestParam double initialBalance) {
        try {
            Account newAccount = accountService.createCheckingAccount(clientId, accountNumber, initialBalance);
            return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/savings")
    public ResponseEntity<Account> createSavingsAccount(
            @RequestParam Long clientId,
            @RequestParam String accountNumber,
            @RequestParam double initialBalance) {
        try {
            Account newAccount = accountService.createSavingsAccount(clientId, accountNumber, initialBalance);
            return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // #Future Function: PUT /api/accounts/{id}/transfer
    // #Future Function: PUT /api/accounts/{id}/deposit
}