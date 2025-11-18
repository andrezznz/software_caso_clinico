package com.software.gestion.citas.clinica.citas_gestion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.software.gestion.citas.clinica.citas_gestion.model.Doctor;
import com.software.gestion.citas.clinica.citas_gestion.repository.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repo;

    public Doctor crear(Doctor doctor) {
        return repo.save(doctor);
    }

    public List<Doctor> listar() {
        return repo.findAll();
    }

    public Doctor obtenerPorId(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}