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

## Creación del proyecto

### Backend
1. Para crear la estrctuctura de carpetas del proyecto utilizó la página: <https://start.spring.io/>, la cual permite generar la estructura de carpetas del proyecto y agregar las dependencias necesarias.
2. Al momento de crear el proyecto se usó Spring Boot *3.5.9*, Java *17*, YAML y Maven *4.0.0*.
3. Después de descargar el comprimido, se utilizó el IDE Antigravity de Google para configurar y abrir el proyecto.
4. Se configura el pom añadiendo las dependencias necesarias que faltan para el proyecto.
5. Se agregan las carpetas para las clases y entidades que se van a utilizar en el proyecto.
    1. *Controller:* Aquí irán las APIs REST (los que reciben las peticiones del Front).
    2. *Domain:* Aquí irán las Entidades (Tablas de la BD).
    3. *Repository:* Aquí irán las interfaces que guardan datos en PostgreSQL.
    4. *Service:* Aquí irá la lógica de negocio (validaciones, cálculos).
    5. *Dto:* Aquí irán los objetos "limpios" que se envian al Frontend (sin contraseñas ni datos sensibles).
    6. *Mapper:* Aquí irán las interfaces de MapStruct para convertir de Entidad a DTO.

### Base de Datos
1. Se instaló PostgreSQL *17.7*.
2. Se inicilizó en el puerto *5432*.
3. Se creó la base de datos llamada `cine_db`.
4. 