package com.software.gestion.citas.clinica.citas_gestion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MensajeResponse {
    private String mensaje;
    private Object data;
}
