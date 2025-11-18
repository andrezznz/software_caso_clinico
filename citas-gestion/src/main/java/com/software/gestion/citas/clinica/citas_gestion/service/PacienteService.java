package com.software.gestion.citas.clinica.citas_gestion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.software.gestion.citas.clinica.citas_gestion.model.Paciente;
import com.software.gestion.citas.clinica.citas_gestion.repository.PacienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repo;

    public Paciente crear(Paciente paciente) {
        return repo.save(paciente);
    }

    public List<Paciente> listar() {
        return repo.findAll();
    }

    public Paciente obtenerPorId(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
