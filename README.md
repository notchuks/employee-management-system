## Employee Management System
Employee Management System Built in Microservices Architecture with Spring Boot, PostgreSQL, Flyway, Docker, Kafka, Spring Cloud, Eureka, and Github Actions.

### Functionalities
- Create Employees & Departments
- JWT Auth (Role-Based Access for Employees, Admins & Managers)
- Flyway for Database Migrations
- Containerized with Docker
- Event-Driven Architecture with Kafka
- Inter-Service communication with FeignClient

<h1 align="center">Employee Management System</h1>
<h2>📋 Table of Contents</h2>

- [🔍 About](#-about)
- [🏛️ Architecture](#-architecture)
- [🚀 Microservices](#-microservices)
- [🚀 Getting Started](#-getting-started)

## 🔍 About
<p>
    The Application is an Employee Management System Built in Microservices Architecture with Spring Boot, PostgreSQL, Flyway, Docker, Kafka, Spring Cloud, Eureka, and Github Actions.

</p>

## 🏛️ Architecture

- **Discovery Service:** This microservice exposes a discovery service for service registration and service discovery, this helps the microservices to discover and communicate with other services, without needing to hardcode the endpoints while communicating with other microservices.

- **API Gateway:** This microservice exposes an API gateway to centralize the API endpoint, where all the endpoints have common entry point to all the endpoints. The API Gateway also facilitates the Security inclusion where protected endpoints and Role-Based Access is enforced.

- **Database per Microservice:** Each of the microservice have their dedicated database. Here for this application for all the microservices we are incorparating the MySQL database. This helps us to isolate each of the services from each other which facilitates each services to have their own data schemas and scale each of the database when required.


<h2>🚀 Microservices</h2>

- **👤 Auth Service:** The auth microservice provides functionalities for user management. This includes user registration, updating user details, viewing user information, and accessing all accounts associated with the user. Additionally, this microservice handles user authentication and authorization processes.

- **💼 Employee Service:** The employee microservice manages employee-related APIs. It enables Admins to create Departments, and Employees can belong to a department.

- **💸 Config Service:** The config microservice manages configuration properties all the microservices. It stores the configuration data in a central location and makes it available to all the microservices.


<h2>🚀 Getting Started</h2>

To get started, follow these steps to run the application on your local application:

- Make sure you have Java 21 installed on your system. You can download it from the official Oracle website.
- Select an Integrated Development Environment (IDE) such as Eclipse, Spring Tool Suite, or IntelliJ IDEA. Configure the IDE according to your preferences.
- Clone the repository containing the microservices onto your local system using Git by running:
- `git clone https://github.com/notchuks/employee-management-system.git'
- Then cd into the folder with `cd employee-management-system`
- Navigate to each microservice directory within the cloned repository and build the application. You can do this by running the command `mvn clean install`
- Go back to the root directory and run `docker compose -up d` to build all the images for each service with an instance of Postgres.
- Some microservices and APIs may depend on others being up and running. Ensure that all necessary microservices and APIs are up and functioning correctly to avoid any issues in the application workflow.
