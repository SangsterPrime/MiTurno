# <img src="https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExa25nM2g1d2xrMGs0eTJ1bTZ6dnBpbmVtZmY2NmFldmo2ZDVvaXhnNiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/78XCFBGOlS6keY1Bil/giphy.gif" width="100"> MiTurno

**MiTurno** es una aplicación desarrollada en Java para la gestión de turnos en entornos donde se requiere atención organizada de usuarios, como instituciones públicas o privadas.

---

## 🔧 Funcionalidades

- Solicitar y visualizar turnos.
- Gestión de usuarios y horarios.
- Panel de administración para gestión de módulos, sucursales y trabajadores.

---

## 🛠️ Tecnologías Usadas

- **Lenguaje:** Java
- **Framework:** Spring Boot
- **Base de Datos:** MySQL / SQLite
- **Control de versiones:** Git + GitHub
- **IDE recomendado:** IntelliJ IDEA / Eclipse

---

## 🚀 Cómo Ejecutarlo

```bash
git clone https://github.com/SangsterPrime/MiTurno.git
# Importar el proyecto en tu IDE
# Configurar base de datos en `application.properties`
# Ejecutar la clase `MiTurnoApplication.java`
```
--- 

## 📂 Estructura del Proyecto

```md
MiTurno/
│
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
│
├── .vscode/
│   └── settings.json
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/MiTurno/MiTurno/
│   │   │       ├── MiTurnoApplication.java
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   ├── ConfiguracionController.java
│   │   │       │   ├── InstitucionController.java
│   │   │       │   ├── ModuloController.java
│   │   │       │   ├── RolController.java
│   │   │       │   ├── SucursalController.java
│   │   │       │   ├── TrabajadorController.java
│   │   │       │   ├── TurnoController.java
│   │   │       │   └── UsuarioController.java
│   │   │       │
│   │   │       ├── model/
│   │   │       │   ├── Configuracion.java
│   │   │       │   ├── Estado.java
│   │   │       │   ├── EstadoModulo.java
│   │   │       │   ├── Institucion.java
│   │   │       │   ├── Modulo.java
│   │   │       │   ├── Rol.java
│   │   │       │   ├── Sucursal.java
│   │   │       │   ├── Trabajador.java
│   │   │       │   ├── Turno.java
│   │   │       │   └── Usuario.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   ├── ConfiguracionRepository.java
│   │   │       │   ├── InstitucionRepository.java
│   │   │       │   ├── ModuloRepository.java
│   │   │       │   ├── RolRepository.java
│   │   │       │   ├── SucursalRepository.java
│   │   │       │   ├── TrabajadorRepository.java
│   │   │       │   ├── TurnoRepository.java
│   │   │       │   └── UsuarioRepository.java
│   │   │       │
│   │   │       └── service/
│   │   │           ├── ConfiguracionService.java
│   │   │           ├── InstitucionService.java
│   │   │           ├── ModuloService.java
│   │   │           ├── RolService.java
│   │   │           ├── SucursalService.java
│   │   │           ├── TrabajadorService.java
│   │   │           ├── TurnoService.java
│   │   │           └── UsuarioService.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   │
│   └── test/
│       └── java/com/MiTurno/MiTurno/
│           └── MiTurnoApplicationTests.java
│
├── target/
│   ├── classes/
│   │   ├── application.properties
│   │   └── com/MiTurno/MiTurno/
│   │       ├── MiTurnoApplication.class
│   │       ├── controller/*.class
│   │       ├── model/*.class
│   │       ├── repository/*.class
│   │       └── service/*.class
│   │
│   ├── test-classes/
│   │   └── com/MiTurno/MiTurno/
│   │       └── MiTurnoApplicationTests.class
│   │
│   ├── generated-sources/
│   │   └── annotations/
│   └── generated-test-sources/
│       └── test-annotations/
```
---

## 🧑‍💻 Autor

Desarrollado por [Sangster](https://github.com/SangsterPrime) && compañeros

 ---

<h2>📄 ⚖️ Licencia</h2>
<pre>
MIT License

Copyright (c) 2025 Joel Sangster

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
</pre>
## 📄 Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](https://github.com/SangsterPrime/MiTurno/blob/main/LICENSE) para más detalles.

