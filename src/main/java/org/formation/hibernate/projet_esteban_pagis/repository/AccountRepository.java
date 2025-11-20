package org.formation.hibernate.projet_esteban_pagis.repository;

import org.formation.hibernate.projet_esteban_pagis.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByClientId(Long clientId);
}