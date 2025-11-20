package org.formation.hibernate.projet_esteban_pagis.service;

import org.formation.hibernate.projet_esteban_pagis.model.Advisor;
import org.formation.hibernate.projet_esteban_pagis.repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdvisorService {

    @Autowired
    private AdvisorRepository advisorRepository;

    public List<Advisor> findAll() {
        return advisorRepository.findAll();
    }

    public Optional<Advisor> findById(Long id) {
        return advisorRepository.findById(id);
    }

    public Advisor save(Advisor advisor) {
        return advisorRepository.save(advisor);
    }
}