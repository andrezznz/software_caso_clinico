# 🏥 Sistema de Gestión Clínica – API REST (Spring Boot)

Este proyecto consiste en el desarrollo de un sistema básico de gestión clínica implementado como una API REST utilizando Spring Boot. El sistema permite administrar usuarios de diferentes tipos (Administradores, Doctores y Pacientes) y gestionar citas médicas entre doctores y pacientes.

El proyecto fue desarrollado aplicando principios de arquitectura limpia, diseño orientado a objetos e implementación de entidades heredadas utilizando la estrategia **Single Table (STI)** con el atributo `dtype` para distinguir los tipos de usuario.

---

## 📌 Características principales

### 👤 Gestión de Usuarios

Se utiliza una única tabla (`usuario`) donde se almacenan:

* **Administradores** (con campo `area`)
* **Doctores** (con `especialidad`)
* **Pacientes** (con `direccion`)

Cada tipo se diferencia mediante el atributo `dtype`.

### 📅 Gestión de Citas Médicas

Una cita (`cita`) contiene:

* Fecha y hora
* Motivo
* Relación con un paciente
* Relación con un doctor

La tabla `cita` referencia la tabla `usuario` mediante claves foráneas.

### 🔗 API REST documentada

La API permite:

* Crear, actualizar, eliminar y consultar usuarios.
* Crear y consultar citas.
* Validación automática con Spring.
* Endpoints probados mediante Postman.

---

## 🛠️ Tecnologías utilizadas

| Componente | Tecnología |
| :--- | :--- |
| Backend | Spring Boot 3 |
| Lenguaje | Java 17 |
| Base de Datos | MySQL |
| JPA / ORM | Hibernate |
| Documentación y pruebas | Postman |
| Dependencias adicionales | Spring Web, Spring Data JPA, MySQL Driver |

---

## 🏗️ Desarrollo

El sistema fue construido aplicando buenas prácticas:

* Herencia JPA para manejar roles en una sola tabla.
* Relaciones `ManyToOne` entre citas y usuarios.
* Validaciones a nivel de modelo y entrada de datos.
* Capa `service` para lógica de negocio.
* Capa `controller` (REST) para exponer los endpoints.
* Pruebas de API con Postman importando los endpoints CRUD.

---

## 📄 Documentación

El proyecto incluye:

* Script SQL de creación de tablas
* Inserciones para pruebas
* Colección de endpoints para Postman
* Explicación de relaciones entre entidades
* Diagrama UML de clases (opcional según entrega)

---

## ✔️ Atributo de calidad: Funcionalidad

El proyecto garantiza funcionalidad completa porque:

* Implementa correctamente todas las operaciones CRUD requeridas.
* Las relaciones entre entidades funcionan y se validan.
* Se puede interactuar con el sistema mediante Postman.
* La base de datos almacena información real y persistente.
* La API responde correctamente en formato JSON.

---

## 🚀 Cómo ejecutar el proyecto

1️⃣ **Clonar el repositorio**

```bash
git clone <url-del-repositorio>
```

2️⃣ **Configurar la base de datos MySQL**

```bash
CREATE DATABASE clinica;
USE clinica;
```

3️⃣ **Actualizar application.properties**

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/clinica
spring.datasource.username=root
spring.datasource.password=tu_clave
spring.jpa.hibernate.ddl-auto=update
```

4️⃣ **Ejecutar la aplicación**

```bash
mvn spring-boot:run
```

---

## 📬 Pruebas con Postman

Ejemplos básicos:

### Crear un Usuario Doctor

`POST /usuarios`

```json
{
  "dtype": "Doctor",
  "nombre": "Dr. Juan Pérez",
  "email": "juan@clinic.com",
  "especialidad": "Cardiología"
}
```

### Crear una Cita

`POST /citas`

```json
{
  "fechaHora": "2025-01-25T10:00:00",
  "motivo": "Consulta general",
  "pacienteId": 4,
  "doctorId": 2
}
```







