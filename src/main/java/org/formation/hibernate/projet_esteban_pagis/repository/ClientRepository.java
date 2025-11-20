package org.formation.hibernate.projet_esteban_pagis.repository;

import org.formation.hibernate.projet_esteban_pagis.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByAdvisorId(Long advisorId);
}