package org.formation.hibernate.projet_esteban_pagis.service;

import org.formation.hibernate.projet_esteban_pagis.model.BankCard;
import org.formation.hibernate.projet_esteban_pagis.model.CardType;
import org.formation.hibernate.projet_esteban_pagis.model.CheckingAccount;
import org.formation.hibernate.projet_esteban_pagis.repository.AccountRepository;
import org.formation.hibernate.projet_esteban_pagis.repository.BankCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class BankCardService {

    @Autowired
    private BankCardRepository bankCardRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public BankCard createCard(Long checkingAccountId, CardType cardType) {
        CheckingAccount account = (CheckingAccount) accountRepository.findById(checkingAccountId)
                .orElseThrow(() -> new RuntimeException("Checking account not found"));

        BankCard card = new BankCard();
        card.setCardNumber(generateCardNumber());
        card.setCardType(cardType);
        card.setIssueDate(LocalDate.now());
        card.setExpiryDate(LocalDate.now().plusYears(3));
        card.setActive(true);
        card.setCheckingAccount(account);

        return bankCardRepository.save(card);
    }

    @Transactional
    public void deactivateCard(Long cardId) {
        BankCard card = bankCardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        card.setActive(false);
        bankCardRepository.save(card);
    }

    private String generateCardNumber() {
        return "4" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 15);
    }
}