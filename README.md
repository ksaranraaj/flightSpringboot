# Flight Spring Boot Application

A simple Spring Boot application for managing flight data with H2 in-memory database support and OpenAPI UI.

## Project Overview

- Spring Boot 3.3.5
- Java 17
- Spring Data JPA
- Spring Web
- H2 embedded database
- Springdoc OpenAPI UI

## Key Features

- REST API for flight operations
- Embedded H2 database for development and testing
- H2 console enabled for database inspection
- OpenAPI UI for API documentation

## Getting Started

### Prerequisites

- Java 17
- Maven
- Git (optional)

### Build

```bash
mvn clean package
```

### Run

```bash
mvn spring-boot:run
```

or run the generated jar:

```bash
java -jar target/Flight-0.0.1-SNAPSHOT.jar
```

### Default Configuration

- Application port: `8080`
- H2 JDBC URL: `jdbc:h2:~/test`
- H2 username: `sa`
- H2 password: `password`
- H2 console: `http://localhost:8080/h2-console`
- OpenAPI UI: `http://localhost:8080/swagger-ui.html`

## H2 Console Access

Open the browser and visit:

```text
http://localhost:8080/h2-console
```

Use the following settings:

- JDBC URL: `jdbc:h2:~/test`
- User Name: `sa`
- Password: `password`

## API Documentation

Swagger UI is available at:

```text
http://localhost:8080/swagger-ui.html
```

## Tests

Run unit tests with:

```bash
mvn test
```

## Notes

- The application uses `spring.jpa.hibernate.ddl-auto=update`, so the schema is automatically updated on startup.
- Logs are written to `logs/logging.txt`.
