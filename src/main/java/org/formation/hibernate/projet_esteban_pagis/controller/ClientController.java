package org.formation.hibernate.projet_esteban_pagis.controller;

import org.formation.hibernate.projet_esteban_pagis.dto.ClientDTO;
import org.formation.hibernate.projet_esteban_pagis.mapper.ClientMapper;
import org.formation.hibernate.projet_esteban_pagis.model.Client;
import org.formation.hibernate.projet_esteban_pagis.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.findAll().stream()
                .map(clientMapper::toClientDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return clientService.findById(id)
                .map(clientMapper::toClientDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(
            @RequestParam Long advisorId,
            @RequestBody Client client) {
        try {
            Client newClient = clientService.createClient(advisorId, client);
            return new ResponseEntity<>(newClient, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}