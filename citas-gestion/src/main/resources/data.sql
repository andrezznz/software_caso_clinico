-- Administrador
INSERT INTO usuario (id, dtype, nombre, correo, nivel_acceso)
VALUES (1, 'Administrador', 'Admin General', 'admin@clinic.com', 'Gestión');

-- Doctores
INSERT INTO usuario (id, dtype, nombre, correo, especialidad)
VALUES (2, 'Doctor', 'Dr. Juan Pérez', 'juan@clinic.com', 'Cardiología');

INSERT INTO usuario (id, dtype, nombre, correo, especialidad)
VALUES (3, 'Doctor', 'Dra. María López', 'maria@clinic.com', 'Pediatría');

-- Pacientes
INSERT INTO usuario (id, dtype, nombre, correo, historial_clinico)
VALUES (4, 'Paciente', 'Carlos Ruiz', 'carlos@clinic.com', 'Sin antecedentes');

INSERT INTO usuario (id, dtype, nombre, correo, historial_clinico)
VALUES (5, 'Paciente', 'Ana Torres', 'ana@clinic.com', 'Alergia a penicilina');

-- Citas
INSERT INTO cita (fecha, estado, paciente_id, doctor_id)
VALUES ('2025-01-25', 'CREADA', 4, 2);

INSERT INTO cita (fecha, estado, paciente_id, doctor_id)
VALUES ('2025-01-26', 'CREADA', 5, 3);
