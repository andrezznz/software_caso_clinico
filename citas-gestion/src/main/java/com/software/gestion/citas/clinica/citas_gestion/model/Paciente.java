package com.software.gestion.citas.clinica.citas_gestion.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Paciente")
public class Paciente extends Usuario {

    private String historialClinico;
}

