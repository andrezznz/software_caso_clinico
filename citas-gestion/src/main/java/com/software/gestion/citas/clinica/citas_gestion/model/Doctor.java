package com.software.gestion.citas.clinica.citas_gestion.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Doctor")
public class Doctor extends Usuario {

    private String especialidad;

}

