package org.formation.hibernate.projet_esteban_pagis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private String address;
    private String postalCode;
    private String city;
    private String phoneNumber;

    @ManyToOne
    @JsonIgnoreProperties("clients")
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;
}