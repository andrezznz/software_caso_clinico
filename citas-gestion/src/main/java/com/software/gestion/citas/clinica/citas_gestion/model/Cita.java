package com.software.gestion.citas.clinica.citas_gestion.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Doctor doctor;
}