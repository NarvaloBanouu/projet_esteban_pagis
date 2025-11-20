package org.formation.hibernate.projet_esteban_pagis;

import org.formation.hibernate.projet_esteban_pagis.model.Account;
import org.formation.hibernate.projet_esteban_pagis.model.Advisor;
import org.formation.hibernate.projet_esteban_pagis.model.Client;
import org.formation.hibernate.projet_esteban_pagis.service.AccountService;
import org.formation.hibernate.projet_esteban_pagis.service.AdvisorService;
import org.formation.hibernate.projet_esteban_pagis.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjetEstebanPagisApplicationTests {

    @Autowired
    private AdvisorService advisorService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    @Test
    void testProxiBanque() {
        // Creer conseiller
        Advisor conseiller = new Advisor(null, "Pierre", "Michel", null);
        conseiller = advisorService.save(conseiller);
        System.out.println("Conseiller cree : " + conseiller.getLastName() + " (ID: " + conseiller.getId() + ")");

        // Creer client
        Client client = new Client(null, "Pagis", "Esteban", "10 Rue Paris", "75001", "Paris", "0666666666", null, null);
        client = clientService.createClient(conseiller.getId(), client);
        System.out.println("Client cree : " + client.getLastName() + " (ID: " + client.getId() + ")");

        // Creer compte courant
        Account compteCourant = accountService.createCheckingAccount(client.getId(), "CC001", 1000.0);
        System.out.println("Compte courant cree : " + compteCourant.getAccountNumber());

        // Creer compte epargne
        Account compteEpargne = accountService.createSavingsAccount(client.getId(), "CE001", 5000.0);
        System.out.println("Compte epargne cree : " + compteEpargne.getAccountNumber());

        // Lister comptes
        List<Account> comptes = accountService.findAccountsByClient(client.getId());
        System.out.println("Nombre de comptes : " + comptes.size());

        // Supprimer client
        Long clientId = client.getId();
        clientService.deleteClient(clientId);
        System.out.println("Client supprime");

        // Verifier suppression
        boolean clientExiste = clientService.findById(clientId).isPresent();
        System.out.println("Client existe apres suppression : " + clientExiste);

        List<Account> comptesApres = accountService.findAccountsByClient(clientId);
        System.out.println("Nombre de comptes apres suppression : " + comptesApres.size());
    }

    @Test
    void contextLoads() {
    }
}