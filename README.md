# 📊 Employee Management API

This is a RESTful API for managing employee records, built with **Spring Boot** and **PostgreSQL**. The API provides endpoints for creating, updating, retrieving, and listing employees.

## 🛠 Technologies

- **Spring Boot**: Framework for building the RESTful API.
- **PostgreSQL**: Relational database for storing employee data.
- **Java**: Programming language used.

## 🚀 Getting Started

### Prerequisites

Before running the application, ensure you have the following installed:

1. **Java Development Kit (JDK)**: Version 11 or later.
2. **Spring Boot**: Set up your Spring Boot environment.
3. **PostgreSQL**: Install and configure PostgreSQL on your machine.

### Setup Instructions

1. **Clone the repository**

   ```bash
   gh repo clone tusharyadav/test

2. **Navigate to the project directory**
   ```bash
   cd test
3. **Configure PostgreSQL**
   Ensure PostgreSQL is running.
   Create a database for the application (e.g., employee_db).
   Update the database credentials in src/main/resources/application.properties.
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password

4. **Build and run the application**
   ```bash
   ./mvnw spring-boot:run

5. **📚 API Documentation**
   **Add Employee**
- URL: /employees
- Method: POST
- Request Body: EmployeeRequest
- Response: Employee
- Description: Adds a new employee to the system.

**Update Employee**
- URL: /employees/{id}
- Method: PUT
- Request Body: EmployeeRequest
- Response: Employee
- Description: Updates the details of an existing employee by id.

**Get Employee**
- URL: /employees/{id}
- Method: GET
- Response: Employee
- Description: Retrieves the details of an employee by id.

**Get All Employees**
- URL: /employees
- Method: GET
- Response: List<Employee>
- Description: Retrieves a list of all employees.

**Holiday Management**
- Get Holidays for the Next 7 Days
- Endpoint: GET /api/holidays
- Description: Fetches holidays for the next 7 days based on the country code.
- Query Parameters:
- countryCode (required): The country code for which to fetch holidays.

**⚠️ Exception Handling**
The API uses custom exception handling for error scenarios. When an error occurs, a CustomExceptions will be thrown with an appropriate message and HTTP status code.

