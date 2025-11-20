package org.formation.hibernate.projet_esteban_pagis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String postalCode;
    private String city;
    private String phoneNumber;

    private AdvisorDTO advisor;
}