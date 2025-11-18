package com.software.gestion.citas.clinica.citas_gestion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.software.gestion.citas.clinica.citas_gestion.model.*;
import com.software.gestion.citas.clinica.citas_gestion.repository.*;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioCitas {

    private final CitaRepository citaRepository;
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    // Listar todas las citas
    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    // Obtener cita por ID
    public Cita obtener(Integer id) {
        return citaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("La cita no existe"));
    }

    public Cita crear(LocalDate fecha, Integer doctorId, Integer pacienteId) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("El doctor no existe"));

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("El paciente no existe"));

        Cita cita = new Cita();
        cita.setFecha(fecha);
        cita.setDoctor(doctor);
        cita.setPaciente(paciente);
        cita.setEstado(EstadoCita.PENDIENTE);

        return citaRepository.save(cita);
    }

    // Cambiar estado de una cita
    public Cita cambiarEstado(Integer id, EstadoCita nuevoEstado) {
        Cita cita = obtener(id);
        cita.setEstado(nuevoEstado);
        return citaRepository.save(cita);
    }

    // Reprogramar cita
    public Cita reprogramar(Integer id, LocalDate nuevaFecha) {
        Cita cita = obtener(id);
        cita.setFecha(nuevaFecha);
        cita.setEstado(EstadoCita.REPROGRAMADA);
        return citaRepository.save(cita);
    }

    // Eliminar cita
    public void eliminar(Integer id) {
        Cita cita = obtener(id);
        citaRepository.delete(cita);
    }
}
