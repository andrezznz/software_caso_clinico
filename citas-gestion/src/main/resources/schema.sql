DROP TABLE IF EXISTS cita;
DROP TABLE IF EXISTS usuario;

-- Tabla Usuario (Administrador, Doctor, Paciente)
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dtype VARCHAR(31) NOT NULL,     -- Identificador de subclase
    nombre VARCHAR(255),
    correo VARCHAR(255) UNIQUE,
    contrasena VARCHAR(255),

    -- Solo Doctor
    especialidad VARCHAR(255),

    -- Solo Paciente
    historial_clinico VARCHAR(500),

    -- Solo Administrador
    nivel_acceso VARCHAR(255)
);

-- Tabla Cita
CREATE TABLE cita (
    id_cita BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    estado VARCHAR(50),

    paciente_id BIGINT,
    doctor_id BIGINT,

    FOREIGN KEY (paciente_id) REFERENCES usuario(id),
    FOREIGN KEY (doctor_id) REFERENCES usuario(id)
);
