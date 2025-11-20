package org.formation.hibernate.projet_esteban_pagis.mapper;

import org.formation.hibernate.projet_esteban_pagis.dto.AdvisorDTO;
import org.formation.hibernate.projet_esteban_pagis.dto.ClientDTO;
import org.formation.hibernate.projet_esteban_pagis.model.Advisor;
import org.formation.hibernate.projet_esteban_pagis.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    // Conversion Advisor -> AdvisorDTO
    public AdvisorDTO toAdvisorDTO(Advisor advisor) {
        if (advisor == null) {
            return null;
        }
        return new AdvisorDTO(
                advisor.getId(),
                advisor.getLastName(),
                advisor.getFirstName()
        );
    }

    // Conversion Client -> ClientDTO
    public ClientDTO toClientDTO(Client client) {
        if (client == null) {
            return null;
        }

        AdvisorDTO advisorDTO = toAdvisorDTO(client.getAdvisor());

        return new ClientDTO(
                client.getId(),
                client.getLastName(),
                client.getFirstName(),
                client.getAddress(),
                client.getPostalCode(),
                client.getCity(),
                client.getPhoneNumber(),
                advisorDTO
        );
    }
}