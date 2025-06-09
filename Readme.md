# 🎵 Cancionero Musical - Proyecto JPA con Spring Boot

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1%2B-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blueviolet)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.1%2B-yellowgreen)

## 📌 Descripción

Proyecto de práctica donde implementé un sistema de gestión musical usando:
- **Spring Data JPA** para persistencia
- **PostgreSQL** como base de datos
- **Relaciones bidireccionales** entre entidades
- **Consultas derivadas** y **JPQL** para búsquedas avanzadas

## 🎯 Características

### 🎤 Módulo de Cantantes

## Ejemplo de query derivada
`` List<Cantante> findByNombresContainingIgnoreCase(String nombre);
``


# 🚀 Mi Cancionero Personal: ¡Un Viaje Musical con Spring Boot y JPA! 🎵

¡Hola, amantes de la música y la programación! 👋 Estoy emocionado de compartirles mi proyecto **"Cancionero"**. Es una aplicación de consola que construí para practicar y afianzar conceptos clave en el desarrollo backend con Java. Piensen en él como su base de datos musical personal, ¡donde cada artista y cada canción encuentran su lugar!

---

## ✨ ¿Qué puedes hacer con este Cancionero?

Este pequeño cancionero está diseñado para ser intuitivo y útil. ¡Aquí te muestro lo que puedes lograr con él!

1.  **🎤 Registrar Nuevos Cantantes**: ¿Descubriste un nuevo artista increíble? ¡Agrégalo con su nombre, país de origen y edad!
2.  **🎶 Añadir Canciones a tus Cantantes**: Una vez que tengas a tus artistas, puedes asignarles todas sus canciones. Solo necesitas el ID del cantante y los detalles de la canción (título, género, duración).
3.  **🔎 Buscar Cantantes por Nombre**: ¿Olvidaste quién canta esa canción que no puedes sacar de tu cabeza? ¡Búscalo fácilmente por su nombre!
4.  **🎧 Buscar Canciones por Título**: Encuentra tu tema favorito al instante escribiendo solo una parte de su título.

---

## 🛠️ Detrás de Escena: La Magia que Aprendí y Apliqué

Este proyecto ha sido un campo de juego increíble para consolidar mis habilidades en **Spring Boot** y la persistencia de datos. Cada línea de código fue una oportunidad para aprender algo nuevo. ¡Aquí les cuento los highlights técnicos!

### 🌿 **Spring Data JPA: ¡Mi Superpoder para la Base de Datos!**

* **Entidades y Relaciones**: Aprendí a modelar las entidades `Cantante` y `Cancion` usando anotaciones JPA. Esto incluye establecer la relación **uno a muchos** (un cantante puede tener muchas canciones), lo cual es fundamental para organizar los datos de manera eficiente.
* **Repositorios Mágicos**: Utilicé `JpaRepository` para interactuar con la base de datos de una forma súper elegante. ¡Olvídate de escribir SQL manualmente! Métodos como `save()`, `findAll()` y `findById()` se encargan de todo.

### 🧠 **Inteligencia en las Consultas: ¡Cuando Spring te Lee la Mente!**

* **`Querys Derivadas`**: ¡Esto es genial! Descubrí cómo Spring Data JPA puede generar consultas automáticamente basándose en los nombres de mis métodos. Por ejemplo, `findByNombresContainingIgnoreCase` o `findByTituloContainingIgnoreCase` me permitieron buscar cantantes y canciones por parte de su nombre o título, ignorando mayúsculas y minúsculas, ¡sin escribir ni una sola línea de SQL! 🤯
* **`JPQL (Java Persistence Query Language)`**: Aunque este proyecto no requirió consultas muy complejas que necesitaran JPQL, ahora entiendo su potencial para escribir consultas más elaboradas usando objetos Java en lugar de tablas. Es una herramienta poderosa para escenarios más avanzados.

### 🐘 **PostgreSQL: El Motor de la Base de Datos**

* **Persistencia Real**: Elegí **PostgreSQL** como mi sistema de base de datos relacional. Esto me permitió conectar mi aplicación Spring Boot a un motor de base de datos robusto y real, entendiendo cómo se guardan y recuperan los datos en un entorno productivo.
* **Conexión y Configuración**: Practiqué cómo configurar correctamente la conexión entre Spring y PostgreSQL, un paso crucial en cualquier aplicación que necesite almacenar información.

### 🏗️ **Estructura y Flujo del Código**

* **Arquitectura Limpia**: Organicé el proyecto en capas claras: `model` (para mis entidades), `repository` (para la interacción con la BD) y `principal` (donde reside la lógica del menú y la interacción con el usuario). Esto me ayudó a mantener el código ordenado y fácil de mantener.
* **Inyección de Dependencias**: ¡Un concepto fundamental de Spring! Gracias a `@Autowired` y `@Component`, pude ver cómo Spring se encarga de conectar todas las piezas de mi aplicación, simplificando la gestión de dependencias.

---

## 🚀 ¿Listo para Probar el Cancionero?

¡Anímate a explorar el código y a probarlo tú mismo!

1.  **Clona este repositorio**:
    ```bash
    git clone [https://github.com/tu-usuario/nombre-del-repositorio.git](https://github.com/tu-usuario/nombre-del-repositorio.git)
    cd nombre-del-repositorio
    ```
2.  **Configura tu PostgreSQL**: Asegúrate de tener PostgreSQL instalado y en funcionamiento. Luego, actualiza el archivo `application.properties` en `src/main/resources` con tus credenciales de base de datos (usuario, contraseña, URL).
3.  **Ejecuta la Aplicación**:
    * Puedes usar tu IDE favorito (como IntelliJ IDEA o VS Code con la extensión de Spring Boot).
    * O desde la terminal:
        ```bash
        ./mvnw spring-boot:run
        ```
4.  **¡Interactúa en la Consola!**: Una vez que se inicie, verás un menú amigable en tu terminal. ¡Empieza a ingresar cantantes y canciones!

---

## 💡 Ideas para el Futuro

Este proyecto es una base sólida, y ya estoy pensando en cómo expandirlo:

* **Interfaz Gráfica**: ¿Qué tal una interfaz web con **Thymeleaf** o **React**?
* **Más Detalles**: Añadir más atributos a las canciones (ej. año de lanzamiento, letra).
* **Operaciones CRUD Completas**: Implementar funciones para editar y eliminar cant