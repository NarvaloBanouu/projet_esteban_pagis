package org.formation.hibernate.projet_esteban_pagis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorDTO {
    private Long id;
    private String lastName;
    private String firstName;
}