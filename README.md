# Cinema-Web-Page
This is the repository of the project assessment from the company vortexbird.

## Commits Structure
The commits have a simple structure:
* **NEW:** the files are new in the repository.
* **MODIFY:** changes in files and folders.
* **DELETE:** files and folders that are not longer in the repository.

## Tecnologías Utilizadas
A continuación se muestra el stack tecnológico utilizado en la aplicación:

### 1. Frontend

* **Framework:** React.
* **Lenguaje:** JavaScript/TypeScript.
* **Comunicación:** Consumo de API REST (usando `fetch` o `axios`).

### 2. Backend

Todo esto corre sobre **Java 17** (o superior).

* **Framework Principal:** **Spring Boot** (Gestión de la aplicación y servidor).
* **Capa Web:** **Spring Web** (Para crear los controladores `@RestController`).
* **Base de Datos:** **Spring Data JPA** + **Hibernate** (Para manejar los datos sin escribir SQL a mano).
* **Mapeo de Datos:** **MapStruct** (Para convertir Entidades a DTOs y viceversa).
* **Utilidades:** **Lombok** (Para no escribir Getters, Setters y Constructores manualmente).
* **Validación:** **Bean Validation** (Para asegurar que los emails sean emails, etc.).

### 3. Base de Datos

* **Motor:** PostgreSQL.
* **Diseño:** Modelo Relacional (Tablas y Llaves Foráneas).

### 4. Infraestructura y Servicios Cloud

* **Almacenamiento de Imágenes:** **Firebase Cloud Storage** (o AWS S3). Esto es obligatorio porque *no* podemos guardar las imágenes en la base de datos.
* **Contenedores:** Docker.

## Prueba de APIs
Una vez iniciado el proyecto para probar directamente las APIs, se puede ingresar al enlace <http://localhost:8080/swagger-ui/index.html>, el cual contiene todas las APIs implementadas e indica lo que requiere cada API para ser probada, este devuelve el resultado de la operación y el status.