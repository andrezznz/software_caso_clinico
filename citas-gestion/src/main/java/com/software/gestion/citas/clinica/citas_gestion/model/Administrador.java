package com.software.gestion.citas.clinica.citas_gestion.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Administrador")
public class Administrador extends Usuario {

    private String nivelAcceso;
}
