package org.formation.hibernate.projet_esteban_pagis.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;

    // feature: max 10 clients par advisor
}