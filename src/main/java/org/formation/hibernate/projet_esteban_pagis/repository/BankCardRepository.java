package org.formation.hibernate.projet_esteban_pagis.repository;

import org.formation.hibernate.projet_esteban_pagis.model.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Long> {
}