package com.software.gestion.citas.clinica.citas_gestion.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CrearCitaRequest {

    private LocalDate fecha;
    private Integer doctorId;
    private Integer pacienteId;
}
