package org.formation.hibernate.projet_esteban_pagis.service;

import org.formation.hibernate.projet_esteban_pagis.model.Client;
import org.formation.hibernate.projet_esteban_pagis.model.Advisor;
import org.formation.hibernate.projet_esteban_pagis.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdvisorService advisorService;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client createClient(Long advisorId, Client client) {
        Advisor advisor = advisorService.findById(advisorId)
                .orElseThrow(() -> new RuntimeException("Advisor not found with ID: " + advisorId));

        client.setAdvisor(advisor);

        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}