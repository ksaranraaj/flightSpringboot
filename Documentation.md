# Airline Management System - Complete Documentation

## Table of Contents
1. [Project Overview](#project-overview)
2. [Architecture](#architecture)
3. [Technology Stack](#technology-stack)
4. [Project Structure](#project-structure)
5. [Database Schema](#database-schema)
6. [API Endpoints](#api-endpoints)
7. [Key Components](#key-components)
8. [Setup & Installation](#setup--installation)
9. [Running the Application](#running-the-application)
10. [Swagger UI Documentation](#swagger-ui-documentation)
11. [Features](#features)
12. [Development Guidelines](#development-guidelines)

---

## Project Overview

The **Airline Management System** is a Spring Boot-based REST API application designed to manage airline operations including:
- Flight management
- Flight booking management
- Carrier/Airline management
- User management
- Booking records

This is a full-stack application built with Spring Boot 3.3.5, using Java 17 as the runtime and H2 database for data storage.

**Version:** 0.0.1-SNAPSHOT  
**Java Version:** 17  
**Spring Boot Version:** 3.3.5  
**Build Tool:** Maven  
**Repository:** https://github.com/ksaranraaj/flightSpringboot

---

## Architecture

### Layered Architecture

The application follows a **3-layer architecture pattern**:

```
┌─────────────────────────────────────────────────────┐
│         REST API Controllers Layer                  │
│   (HTTP Requests/Responses)                         │
└──────────────┬──────────────────────────────────────┘
               │
┌──────────────▼──────────────────────────────────────┐
│         Service/Business Logic Layer                │
│   (Business Rules & Data Processing)                │
└──────────────┬──────────────────────────────────────┘
               │
┌──────────────▼──────────────────────────────────────┐
│    Persistence/Data Access Layer (DAO/JPA)          │
│   (Database Operations)                             │
└─────────────────────────────────────────────────────┘
               │
┌──────────────▼──────────────────────────────────────┐
│         Database (H2 In-Memory)                      │
└─────────────────────────────────────────────────────┘
```

### Control Flow

**Request → Controller → Service → Repository → Database → Response**

---

## Technology Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| **Framework** | Spring Boot | 3.3.5 |
| **Language** | Java | 17 |
| **Build Tool** | Maven | 3.x+ |
| **Database** | H2 Database | Latest (Runtime) |
| **ORM** | JPA/Hibernate | Included in Spring Boot |
| **API Documentation** | Springdoc OpenAPI (Swagger) | 2.6.0 |
| **Security** | Spring Security | Included in Spring Boot |
| **Web** | Spring Web (Embedded Tomcat) | Included in Spring Boot |
| **Testing** | JUnit 5, Spring Boot Test | Included in Spring Boot |
| **Development Tools** | Spring DevTools | Included in Spring Boot |

---

## Project Structure

```
AirlineManagementSystem/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/AirlineManagementSystem/
│   │   │   ├── AirlineManagementSystemApplication.java    (Spring Boot Entry Point)
│   │   │   │
│   │   │   ├── beans/                                      (POJO Classes)
│   │   │   │   ├── Flight.java
│   │   │   │   ├── Booking.java
│   │   │   │   ├── BookFlight.java
│   │   │   │   ├── User.java
│   │   │   │   └── Carrier.java
│   │   │   │
│   │   │   ├── persistance/                                (JPA Entity Classes)
│   │   │   │   ├── FlightPO.java
│   │   │   │   ├── BookFlightPO.java
│   │   │   │   └── CarrierPO.java
│   │   │   │
│   │   │   ├── repo/                                       (Data Access Layer - DAO)
│   │   │   │   ├── FlightDao.java
│   │   │   │   ├── FlightRepo.java
│   │   │   │   ├── BookFlightDao.java
│   │   │   │   ├── CarrierDao.java
│   │   │   │   └── UserRepo.java
│   │   │   │
│   │   │   ├── service/                                    (Business Logic Layer)
│   │   │   │   ├── FlightService.java
│   │   │   │   ├── BookFlightService.java
│   │   │   │   ├── CarrierService.java
│   │   │   │   ├── UserService.java
│   │   │   │   └── AuthService.java
│   │   │   │
│   │   │   ├── controllers/                                (REST Endpoints)
│   │   │   │   ├── FlightController.java
│   │   │   │   ├── BookFlightController.java
│   │   │   │   ├── CarrierController.java
│   │   │   │   └── UserController.java
│   │   │   │
│   │   │   ├── Exception/                                  (Custom Exceptions)
│   │   │   │   ├── NotFoundException.java
│   │   │   │   └── ValueNotFound.java
│   │   │   │
│   │   │   └── config/                                     (Configuration)
│   │   │       ├── CORSConfig.java
│   │   │       └── SecurityConfig.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties                      (Main Config)
│   │       └── application-dev.properties                  (Dev Profile Config)
│   │
│   └── test/
│       └── java/com/example/AirlineManagementSystem/
│           └── AirlineManagementSystemApplicationTests.java
│
├── pom.xml                                                 (Maven Configuration)
├── mvnw / mvnw.cmd                                        (Maven Wrapper)
└── HELP.md

```

### Folder Purpose Summary

- **beans/** - Plain Java Objects (POJO) used for API request/response
- **persistance/** - JPA Entity classes mapped to database tables
- **repo/** - Repository interfaces extending Spring Data JPA
- **service/** - Business logic and data processing
- **controllers/** - REST API endpoints
- **Exception/** - Custom exception classes
- **config/** - Spring configuration classes (CORS, Security)

---

## Database Schema

### H2 Database Configuration

**Database:** H2 (In-Memory/File-based)  
**Console URL:** `http://localhost:8070/h2-console`  
**JDBC URL:** `jdbc:h2:file:~/test5;AUTO_RECONNECT=TRUE;AUTO_SERVER=TRUE`  
**Username:** `sa`  
**Password:** `password`

### Database Tables

#### 1. **Flight Table**
```sql
CREATE TABLE Flight (
    flight_id INT PRIMARY KEY,
    carrier_name VARCHAR(100),
    origin VARCHAR(100),
    destination VARCHAR(100),
    air_fare DECIMAL(10, 2),
    seat_capacity_business_class INT,
    seat_capacity_economy_class INT,
    seat_capacity_executive_class INT
);
```

**Attributes:**
- `flight_id` - Unique identifier for the flight
- `carrier_name` - Name of the airline carrier
- `origin` - Departure city/airport
- `destination` - Arrival city/airport
- `air_fare` - Price per ticket
- `seat_capacity_*_class` - Number of seats in each class

#### 2. **BookFlight Table**
```sql
CREATE TABLE BookFlight (
    booking_id INT PRIMARY KEY,
    flight_id INT,
    passenger_id INT,
    booking_date DATE,
    class_type VARCHAR(50),
    FOREIGN KEY (flight_id) REFERENCES Flight(flight_id)
);
```

**Attributes:**
- `booking_id` - Unique booking reference
- `flight_id` - Reference to Flight
- `passenger_id` - User/Passenger ID
- `booking_date` - Date of booking
- `class_type` - Class booked (Business/Economy/Executive)

#### 3. **Carrier Table**
```sql
CREATE TABLE Carrier (
    carrier_id INT PRIMARY KEY,
    carrier_name VARCHAR(100),
    founding_year INT,
    headquarters VARCHAR(100)
);
```

**Attributes:**
- `carrier_id` - Unique airline identifier
- `carrier_name` - Name of the airline
- `founding_year` - Year airline was established
- `headquarters` - Main office location

#### 4. **User Table**
```sql
CREATE TABLE User (
    user_id INT PRIMARY KEY,
    username VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    phone_number VARCHAR(15)
);
```

**Attributes:**
- `user_id` - Unique user identifier
- `username` - Login username
- `email` - User email address
- `password` - User password (should be hashed)
- `phone_number` - Contact number

#### 5. **Booking Table**
```sql
CREATE TABLE Booking (
    booking_id INT PRIMARY KEY,
    user_id INT,
    flight_id INT,
    booking_date TIMESTAMP,
    total_price DECIMAL(10, 2),
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (flight_id) REFERENCES Flight(flight_id)
);
```

**Attributes:**
- `booking_id` - Unique booking reference
- `user_id` - Which user made the booking
- `flight_id` - Which flight was booked
- `booking_date` - When the booking was made
- `total_price` - Total booking cost
- `status` - Booking status (CONFIRMED/PENDING/CANCELLED)

---

## API Endpoints

### Base URL
```
http://localhost:8070
```

### Flight Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| **GET** | `/flight/getFlight` | Get sample flight | - |
| **GET** | `/flight/getAllFlights` | Get all flights | - |
| **GET** | `/flight/getFlightById?id={id}` | Get flight by ID | - |
| **POST** | `/flight/addFlight` | Add new flight | Flight JSON |
| **PUT** | `/flight/updateFlight` | Update flight | Flight JSON |
| **DELETE** | `/flight/deleteFlightById/{id}` | Delete single flight | - |
| **DELETE** | `/flight/deleteMultipleFlights?ids={ids}` | Delete multiple flights | - |

**Sample Flight JSON:**
```json
{
  "flightId": 1,
  "carrierName": "Air India",
  "origin": "Delhi",
  "destination": "Mumbai",
  "airFare": 5000.00,
  "seatCapacityBusinessClass": 30,
  "seatCapacityEconomyClass": 150,
  "seatCapacityExecutiveClass": 20
}
```

### Booking Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| **GET** | `/booking/getAllBookings` | Get all bookings | - |
| **GET** | `/booking/getBookingById?id={id}` | Get booking by ID | - |
| **POST** | `/booking/addBooking` | Create new booking | Booking JSON |
| **PUT** | `/booking/updateBooking` | Update booking | Booking JSON |
| **DELETE** | `/booking/deleteBookingById/{id}` | Cancel booking | - |

**Sample Booking JSON:**
```json
{
  "bookingId": 1,
  "userId": 1,
  "flightId": 1,
  "bookingDate": "2024-04-23",
  "totalPrice": 5000.00,
  "status": "CONFIRMED"
}
```

### Carrier Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| **GET** | `/carrier/getAllCarriers` | Get all carriers | - |
| **GET** | `/carrier/getCarrierById?id={id}` | Get carrier by ID | - |
| **POST** | `/carrier/addCarrier` | Add new carrier | Carrier JSON |
| **PUT** | `/carrier/updateCarrier` | Update carrier | Carrier JSON |
| **DELETE** | `/carrier/deleteCarrier/{id}` | Delete carrier | - |

**Sample Carrier JSON:**
```json
{
  "carrierId": 1,
  "carrierName": "Air India",
  "foundingYear": 1932,
  "headquarters": "New Delhi"
}
```

### User Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| **GET** | `/user/getAllUsers` | Get all users | - |
| **GET** | `/user/getUserById?id={id}` | Get user by ID | - |
| **POST** | `/user/addUser` | Register new user | User JSON |
| **PUT** | `/user/updateUser` | Update user profile | User JSON |
| **DELETE** | `/user/deleteUser/{id}` | Delete user account | - |

**Sample User JSON:**
```json
{
  "userId": 1,
  "username": "john_doe",
  "email": "john@example.com",
  "password": "secure_password",
  "phoneNumber": "+91-9876543210"
}
```

### BookFlight Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| **GET** | `/bookflight/getAllBookFlights` | Get all book flights | - |
| **POST** | `/bookflight/addBookFlight` | Add book flight | BookFlight JSON |
| **PUT** | `/bookflight/updateBookFlight` | Update book flight | BookFlight JSON |
| **DELETE** | `/bookflight/deleteBookFlight/{id}` | Delete book flight | - |

---

## Key Components

### 1. Controllers

Controllers handle HTTP requests and call appropriate service methods.

**Example: FlightController**
```java
@RestController
@RequestMapping("flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    
    @GetMapping("getAllFlights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }
    
    @PostMapping("/addFlight")
    public ResponseEntity<Void> addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
        return ResponseEntity.ok().build();
    }
}
```

### 2. Services

Services contain business logic and coordinate between controllers and repositories.

**Example: FlightService**
```java
@Service
public class FlightService {
    @Autowired
    private FlightDao flightDao;
    
    public List<Flight> getAllFlights() {
        List<FlightPO> flightPOList = flightDao.findAll();
        List<Flight> flightList = new ArrayList<>();
        flightPOList.forEach(fp -> flightList.add(convertToPOJO(fp)));
        return flightList;
    }
    
    public void addFlight(Flight flight) {
        FlightPO flightPO = convertToPersistenceObject(flight);
        flightDao.save(flightPO);
    }
}
```

### 3. Repositories (DAO)

Repositories handle database operations using Spring Data JPA.

**Example: FlightDao**
```java
@Repository
public interface FlightDao extends JpaRepository<FlightPO, Integer> {
    // Spring Data JPA provides CRUD operations automatically
    // You can add custom query methods here
}
```

### 4. Entities (Persistence Objects)

JPA entities represent database tables.

**Example: FlightPO**
```java
@Entity
@Table(name = "Flight")
public class FlightPO {
    @Id
    private int flightId;
    private String carrierName;
    private String origin;
    private String destination;
    // ... other fields and getters/setters
}
```

### 5. Beans (POJO)

POJO classes used for API request/response.

**Example: Flight Bean**
```java
@Component
public class Flight {
    private int flightId;
    private String carrierName;
    private String origin;
    private String destination;
    // ... other fields and getters/setters
}
```

### 6. Configuration

- **CORSConfig.java** - Enables Cross-Origin Resource Sharing
- **SecurityConfig.java** - Spring Security configuration

### 7. Exception Handling

- **NotFoundException.java** - Thrown when resource not found
- **ValueNotFound.java** - Thrown when value validation fails

---

## Setup & Installation

### Prerequisites

- **Java 17 or higher** installed
- **Maven 3.8.9 or higher** installed
- **Git** for version control

### Step 1: Clone the Repository

```bash
git clone https://github.com/ksaranraaj/flightSpringboot.git
cd AirlineManagementSystem
```

### Step 2: Verify Java and Maven

```bash
java -version
mvn -version
```

### Step 3: Install Dependencies

```bash
mvn clean install
# or
mvn dependency:resolve
```

### Step 4: Build the Project

```bash
mvn clean package
```

---

## Running the Application

### Option 1: Using Maven (Development)

```bash
mvn spring-boot:run
```

The application will start on **http://localhost:8070**

### Option 2: Using Maven Wrapper (Windows)

```bash
mvnw.cmd spring-boot:run
```

### Option 3: Using Maven Wrapper (Linux/Mac)

```bash
./mvnw spring-boot:run
```

### Option 4: Run JAR File

```bash
mvn clean package
java -jar target/AirlineManagementSystem-0.0.1-SNAPSHOT.jar
```

### Verify Application is Running

Once started, you should see output like:
```
Tomcat started on port(s): 8070 (http) with context path ''
Started AirlineManagementSystemApplication in X.XXX seconds
```

---

## Swagger UI Documentation

### Access Swagger UI

Once the application is running, visit:

**Swagger UI:** `http://localhost:8070/swagger-ui.html`

Or alternative URL:

`http://localhost:8070/swagger-ui/index.html`

### Other OpenAPI Endpoints

- **OpenAPI JSON:** `http://localhost:8070/v3/api-docs`
- **OpenAPI YAML:** `http://localhost:8070/v3/api-docs.yaml`

### Features of Swagger UI

- Browse all available API endpoints
- View request/response schemas
- Test API endpoints directly
- View HTTP status codes
- Download OpenAPI specification

---

## Features

### Current Features ✅

1. **Flight Management**
   - Add, view, update, delete flights
   - Search flights by carrier and fare
   - Manage multiple seat classes (Business, Economy, Executive)

2. **User Management**
   - User registration and profile management
   - User authentication (Spring Security)

3. **Booking Management**
   - Create and manage flight bookings
   - Track booking status (CONFIRMED, PENDING, CANCELLED)
   - Multiple booking per user

4. **Carrier Management**
   - Add and manage airline carriers
   - Track airline information

5. **API Documentation**
   - Swagger/OpenAPI integration
   - Interactive API testing via Swagger UI

6. **Database**
   - H2 in-memory database with persistence
   - Automatic schema generation
   - Console access for database inspection

7. **CORS Support**
   - Cross-Origin Resource Sharing configured
   - Allows frontend applications to access API

### Potential Future Enhancements

- Payment integration
- Email notifications for bookings
- Advanced search and filtering
- Loyalty program management
- Real-time seat availability
- Flight status tracking
- Refund management
- Integration with external airline systems

---

## Development Guidelines

### Code Structure Best Practices

1. **Follow MVC Pattern** - Keep controllers, services, and repositories separate
2. **Use Dependency Injection** - Utilize `@Autowired` annotation
3. **Exception Handling** - Create custom exceptions for specific scenarios
4. **Documentation** - Add Javadoc comments for public methods
5. **Naming Conventions** - Follow Java naming standards (camelCase for variables, PascalCase for classes)

### Adding a New Feature

#### Step 1: Create Entity (Persistence Object)
```java
@Entity
@Table(name = "EntityName")
public class EntityPO {
    @Id
    private int id;
    // ... fields
}
```

#### Step 2: Create Repository
```java
@Repository
public interface EntityDao extends JpaRepository<EntityPO, Integer> {
    // Custom queries if needed
}
```

#### Step 3: Create POJO Bean
```java
@Component
public class Entity {
    private int id;
    // ... fields
}
```

#### Step 4: Create Service
```java
@Service
public class EntityService {
    @Autowired
    private EntityDao entityDao;
    
    // Business logic methods
}
```

#### Step 5: Create Controller
```java
@RestController
@RequestMapping("entity")
public class EntityController {
    @Autowired
    private EntityService entityService;
    
    // API endpoints
}
```

### Testing

Run tests with:
```bash
mvn test
```

### Build and Package

Create a production JAR:
```bash
mvn clean package -DskipTests
```

---

## Application Properties

### Main Configuration (application.properties)
```properties
spring.application.name=AirlineManagementSystem
spring.profiles.active=dev
```

### Development Configuration (application-dev.properties)
```properties
spring.application.name=SpringRestDemo
server.port=8070

# H2 Database Configuration
spring.h2.console.enabled=true
spring.datasource.platform=h2
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:file:~/test5;AUTO_RECONNECT=TRUE;AUTO_SERVER=TRUE
spring.datasource.username=sa
spring.datasource.password=password

# JPA Configuration
spring.jpa.show-sql=true
spring.jpa.defer-datasource-initialization=true
spring.jpa.hibernate.ddl-auto=update

# Management Endpoints
management.endpoint.health.show-details=always
management.endpoints.web.exposure.include=*
```

---

## Git Repository

**GitHub:** https://github.com/ksaranraaj/flightSpringboot

### Common Git Commands

```bash
# Clone repository
git clone https://github.com/ksaranraaj/flightSpringboot.git

# Check status
git status

# Add changes
git add .

# Commit changes
git commit -m "Your commit message"

# Push to remote
git push origin main

# Pull latest changes
git pull origin main
```

---

## Troubleshooting

### Issue: Application won't start (Exit Code 1)

**Solutions:**
1. Verify Java 17 is installed: `java -version`
2. Clear Maven cache: `mvn clean install`
3. Check port 8070 is not in use
4. Review logs in console for specific errors

### Issue: Database errors

1. Delete H2 database file: `rm ~/test5.mv.db`
2. Restart application to recreate database
3. Verify H2 driver is in classpath

### Issue: CORS errors

- Check `CORSConfig.java` is properly configured
- Verify allowed origins are correct

### Issue: Swagger UI not loading

1. Verify `springdoc-openapi-starter-webmvc-ui` dependency is in pom.xml
2. Check `http://localhost:8070/swagger-ui.html` (not just root path)
3. Restart application

---

## Project Metrics

| Metric | Value |
|--------|-------|
| **Java Version** | 17 |
| **Spring Boot Version** | 3.3.5 |
| **Maven Wrapper Included** | Yes |
| **H2 Database** | Yes |
| **Swagger Integration** | Yes (v2.6.0) |
| **Total Controllers** | 4 |
| **Total Services** | 5 |
| **Total Repositories** | 5 |
| **Database Tables** | 5 |

---

## Contact & Support

For issues or questions:
- **GitHub Issues:** https://github.com/ksaranraaj/flightSpringboot/issues
- **Email:** Contact through GitHub profile

---

## License

This project is open source and available under appropriate license terms.

---

**Last Updated:** April 23, 2026  
**Version:** 1.0  
**Documentation Status:** Complete

---

## Quick Reference Guide

### Start Development
```bash
cd AirlineManagementSystem
mvn spring-boot:run
```

### Access Points
- **API Base:** http://localhost:8070
- **Swagger UI:** http://localhost:8070/swagger-ui.html
- **H2 Console:** http://localhost:8070/h2-console
- **Health Check:** http://localhost:8070/actuator/health

### Key Endpoints
- Flights: `/flight/*`
- Bookings: `/booking/*`
- Carriers: `/carrier/*`
- Users: `/user/*`
- BookFlights: `/bookflight/*`

---

**This documentation provides a comprehensive guide to understanding, setting up, and working with the Airline Management System project.**
