package org.formation.hibernate.projet_esteban_pagis.controller;

import org.formation.hibernate.projet_esteban_pagis.dto.AdvisorDTO;
import org.formation.hibernate.projet_esteban_pagis.dto.ClientDTO;
import org.formation.hibernate.projet_esteban_pagis.mapper.ClientMapper;
import org.formation.hibernate.projet_esteban_pagis.model.Advisor;
import org.formation.hibernate.projet_esteban_pagis.service.ClientService;
import org.formation.hibernate.projet_esteban_pagis.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/advisors")
public class AdvisorController {

    @Autowired
    private AdvisorService advisorService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @GetMapping
    public List<AdvisorDTO> getAllAdvisors() {
        return advisorService.findAll().stream()
                .map(clientMapper::toAdvisorDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvisorDTO> getAdvisorById(@PathVariable Long id) {
        return advisorService.findById(id)
                .map(clientMapper::toAdvisorDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/clients")
    public List<ClientDTO> getClientsByAdvisor(@PathVariable Long id) {
        return clientService.findAll().stream()
                .filter(c -> c.getAdvisor() != null && c.getAdvisor().getId().equals(id))
                .map(clientMapper::toClientDTO)
                .toList();
    }

    @PostMapping
    public Advisor createAdvisor(@RequestBody Advisor advisor) {
        return advisorService.save(advisor);
    }
}