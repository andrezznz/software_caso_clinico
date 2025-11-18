package com.software.gestion.citas.clinica.citas_gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.software.gestion.citas.clinica.citas_gestion.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> { }
