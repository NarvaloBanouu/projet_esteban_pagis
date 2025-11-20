package org.formation.hibernate.projet_esteban_pagis.service;

import org.formation.hibernate.projet_esteban_pagis.model.Account;
import org.formation.hibernate.projet_esteban_pagis.model.CheckingAccount;
import org.formation.hibernate.projet_esteban_pagis.model.SavingsAccount;
import org.formation.hibernate.projet_esteban_pagis.model.Client;
import org.formation.hibernate.projet_esteban_pagis.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientService clientService;

    public List<Account> findAccountsByClient(Long clientId) {
        return accountRepository.findByClientId(clientId);
    }

    @Transactional
    public CheckingAccount createCheckingAccount(Long clientId, String accountNumber, double initialBalance) {
        Client client = clientService.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));

        CheckingAccount account = new CheckingAccount(accountNumber, initialBalance, LocalDate.now(), client);
        return accountRepository.save(account);
    }

    @Transactional
    public SavingsAccount createSavingsAccount(Long clientId, String accountNumber, double initialBalance) {
        Client client = clientService.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));

        SavingsAccount account = new SavingsAccount(accountNumber, initialBalance, LocalDate.now(), client);
        return accountRepository.save(account);
    }
}