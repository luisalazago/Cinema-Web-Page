# Cinema-Web-Page 1.0

This project is a digital cinema designed to showcase movie showtimes from all theaters across the country, including various cities, films, and cinemas.

Users must register to purchase tickets; they can buy a minimum of 1 and a maximum of 10. If there are no seats available, the system will not allow the user to purchase tickets for that specific showtime.

The core idea of the project is the integration of various technologies to demonstrate Frontend, Backend, and Database development. The technologies used include: React, Java, Spring Boot, Maven, PostgreSQL, Bootstrap, among others. It is important to highlight that this is a demonstrative project, meaning it is not currently deployed; it serves to visualize the behavior of APIs with database information and how it interacts visually with a user.

## Commits Structure

The commits follow a simple structure:

* **NEW:** files that are new and recently added in the commit (did not exist in the repository).
* **MODIFY:** changes to existing files, folders, paths, etc.
* **DELETE:** files and folders that were removed from the repository.

## Technologies Used

Below is the technology stack used in the application:

### 1. Frontend

* **Framework:** React 19.2.0.
* **Language:** JavaScript/TypeScript.
* **Communication:** REST API Consumption (using `axios 1.13.2`).

### 2. Backend

Everything runs on **Java 17**.

* **Main Framework:** *Spring Boot 3.5.9* (Application management and server). *Maven 3.9*.
* **Web Layer:** *Spring Web* (To create `@RestController` controllers).
* **Database:** *Spring Data JPA* + *Hibernate* (To manage data without writing manual SQL; it translates pure queries into Java functions).
* **Data Mapping:** *MapStruct 1.5.5.Final* (To convert Entities to DTOs and vice versa, ***not yet operational***).
* **Validation:** *Bean Validation* (To ensure email formats are valid and other validation functions).
* **Documentation:** *SpringDoc OpenAPI 2.3.0* (Comments and information for Backend APIs).

### 3. Database

* **Engine:** PostgreSQL *17-alpine*.
* **Design:** Relational Model (Tables and Foreign Keys, ***check repository documentation***).

### 4. Infrastructure and Cloud Services

* **Image Storage:** *Firebase Cloud Storage* (or AWS S3). This is mandatory because it is *not* recommended to store images directly in the database. ***Not yet operational***.
* **Containers:** Docker *3.8*.

## Operation and Testing

To run the application by starting the backend, frontend, and database, Docker was used to generate a container with the three images for each section. These images run within the same container via the ***docker-compose*** file, which contains the commands to run all three "projects" simultaneously.

To generate the images and run them in the same container, use the command:

```bash
docker-compose up --build
```

This command generates the images (if they don't exist), creates the container (if it doesn't exist), and deploys the application locally using the configuration of each section with its respective modules and ports.

To verify that you can interact with the application, check the following route:

```
http://localhost:5173/
```

When you need to rebuild the images from scratch due to significant changes in any of the sections, you must remove the images and generate them again. This is done by using the previous command to build and the following command to shut them down:

```bash
docker-compose down
```

**Note:** This last command preserves the database information. If you want to start completely from scratch, use the command:

```bash
docker-compose down -v
```

## Author and Specifications

For more information regarding the project context and official documentation on how to run each section, check the `HELP.md` files at `/back-end/cine-backend/HELP.md` and `/front-end/cine-frontend/HELP.md`.

* **Author:** Luis Alberto Salazar Gómez.
* **Email:** [luisalazago@gmail.com](mailto:luisalazago@gmail.com).

**Notes:** This project is still under remodeling and construction; ***officially, there is no first version available for use yet***.