package org.formation.hibernate.projet_esteban_pagis.controller;

import org.formation.hibernate.projet_esteban_pagis.model.Advisor;
import org.formation.hibernate.projet_esteban_pagis.model.Client;
import org.formation.hibernate.projet_esteban_pagis.service.ClientService;
import org.formation.hibernate.projet_esteban_pagis.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/advisors")
public class AdvisorController {

    @Autowired
    private AdvisorService advisorService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Advisor> getAllAdvisors() {
        return advisorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advisor> getAdvisorById(@PathVariable Long id) {
        return advisorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/clients")
    public List<Client> getClientsByAdvisor(@PathVariable Long id) {
        return clientService.findAll().stream()
                .filter(c -> c.getAdvisor() != null && c.getAdvisor().getId().equals(id))
                .toList();
    }

    @PostMapping
    public Advisor createAdvisor(@RequestBody Advisor advisor) {
        return advisorService.save(advisor);
    }
}