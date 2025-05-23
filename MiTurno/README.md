﻿# 📦 Estructura Interna del Proyecto - MiTurno

Este directorio contiene la lógica principal del proyecto **MiTurno**, donde se agrupan los paquetes por capas para mantener un orden limpio y escalable.

---

## 📁 Estructura por Capas

```bash
src/
└── main/
    └── java/com/MiTurno/
        ├── controller/      # Controladores REST: entrada y salida de datos
        ├── model/           # Entidades que representan la base de datos
        ├── repository/      # Interfaces para persistencia con JPA
        ├── service/         # Lógica del negocio (clases de servicio)
        └── MiTurnoApplication.java  # Clase principal para iniciar Spring Boot
```

---

## 🧠 Convenciones del Código
- Nombres en inglés para clases y métodos.
- Anotaciones de Spring Boot como ``@RestController``, ``@Service``, ``@Repository``, etc.
- Evita lógica de negocio en los controladores.

---

## 🧪 Testing
Los tests están en:

```bash
Copiar
Editar
src/
└── test/
    └── java/com/MiTurno/
        ├── service/
        └── controller/
```

---

## 🔧 ¿Cambiaste algo?
Recuerda documentarlo aquí para mantener claridad al trabajar en equipo o escalar el proyecto.

---

"Construido desde la base, pensado para escalar."
