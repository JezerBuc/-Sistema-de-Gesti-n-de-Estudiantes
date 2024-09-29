# Sistema de Gestión de Estudiantes

Este es un proyecto básico de un sistema CRUD (Create, Read, Update, Delete) para gestionar estudiantes utilizando Java, Spring Boot y MySQL. El sistema permite las siguientes operaciones:

- **GET**: Consultar la lista de estudiantes.
- **POST**: Agregar un nuevo estudiante.
- **PUT**: Actualizar la información de un estudiante.
- **DELETE**: Eliminar un estudiante.

El proyecto sigue la arquitectura de capas (Model, Service, Repository, Controller) y se conecta a una base de datos MySQL. Para probar las operaciones CRUD, se ha utilizado **Postman** como herramienta para realizar las peticiones HTTP.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **MySQL**
- **Postman**

## Pruebas con Postman

Para probar las operaciones CRUD de este sistema, se utilizó **Postman**. A continuación, se presentan las peticiones utilizadas:

1. **GET**: `GET /students` - Obtiene la lista de estudiantes.
2. **POST**: `POST /students` - Agrega un nuevo estudiante.
3. **PUT**: `PUT /students/{id}` - Actualiza un estudiante por su ID.
4. **DELETE**: `DELETE /students/{id}` - Elimina un estudiante por su ID.


