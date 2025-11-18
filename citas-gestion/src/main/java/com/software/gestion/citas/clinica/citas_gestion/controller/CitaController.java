package com.software.gestion.citas.clinica.citas_gestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.software.gestion.citas.clinica.citas_gestion.dto.CrearCitaRequest;
import com.software.gestion.citas.clinica.citas_gestion.service.ServicioCitas;
import com.software.gestion.citas.clinica.citas_gestion.model.Cita;
import com.software.gestion.citas.clinica.citas_gestion.model.EstadoCita;
import com.software.gestion.citas.clinica.citas_gestion.dto.MensajeResponse;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final ServicioCitas servicioCitas;

    // ---------------------------------------------------
    // CREAR CITA
    // ---------------------------------------------------
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody CrearCitaRequest request) {

        Cita cita = servicioCitas.crear(
                request.getFecha(),
                request.getDoctorId(),
                request.getPacienteId()
        );

        return ResponseEntity.ok(
                new MensajeResponse("Cita creada con éxito", cita)
        );
    }

    // ---------------------------------------------------
    // LISTAR TODAS LAS CITAS
    // ---------------------------------------------------
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(servicioCitas.listar());
    }

    // ---------------------------------------------------
    // OBTENER CITA POR ID
    // ---------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(servicioCitas.obtener(id));
    }

    // ---------------------------------------------------
    // CANCELAR CITA
    // ---------------------------------------------------
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<?> cancelar(@PathVariable Integer id) {

        Cita actualizada = servicioCitas.cambiarEstado(id, EstadoCita.CANCELADA);

        return ResponseEntity.ok(
                new MensajeResponse("Cita cancelada correctamente", actualizada)
        );
    }

    // ---------------------------------------------------
    // CONFIRMAR CITA
    // ---------------------------------------------------
    @PutMapping("/{id}/confirmar")
    public ResponseEntity<?> confirmar(@PathVariable Integer id) {

        Cita actualizada = servicioCitas.cambiarEstado(id, EstadoCita.CONFIRMADA);

        return ResponseEntity.ok(
                new MensajeResponse("Cita confirmada correctamente", actualizada)
        );
    }

    // ---------------------------------------------------
    // REPROGRAMAR CITA (CAMBIAR FECHA)
    // ---------------------------------------------------
    @PutMapping("/{id}/reprogramar")
    public ResponseEntity<?> reprogramar(
            @PathVariable Integer id,
            @RequestParam String nuevaFecha
    ) {
        LocalDate fecha = LocalDate.parse(nuevaFecha);

        Cita cita = servicioCitas.reprogramar(id, fecha);

        return ResponseEntity.ok(
                new MensajeResponse("Cita reprogramada correctamente", cita)
        );
    }

}
