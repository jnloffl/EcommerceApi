# Ecommerce API - Spring Boot REST API

## Overview
A RESTful API for managing e-commerce products built with Spring Boot, featuring **Spring Security** with session-based authentication, role-based authorization, and MySQL database persistence.

## Technologies Used
- Java 21
- Spring Boot 4.0.6
- Spring Security (Session-based Auth)
- Spring Data JPA
- MySQL 8.0
- Gradle
- Lombok
- Spring Validation

## Security Features

### Authentication (Session-Based)
- **User Registration:** `POST /api/auth/register`
- **Login:** Form-based login with Basic Auth
- **Password Hashing:** BCrypt (10 rounds)
- **Session Management:** HTTP Sessions with JSESSIONID cookie

### Authorization (Role-Based)
| Role | Permissions |
|------|-------------|
| `ROLE_USER` | View products |
| `ROLE_ADMIN` | View, create, update, and delete products |

### Protected Endpoints
| Endpoint | Access |
|----------|--------|
| `GET /api/v1/products` | Public |
| `POST /api/v1/products` | ADMIN only |
| `PUT /api/v1/products/{id}` | ADMIN only |
| `DELETE /api/v1/products/{id}` | ADMIN only |
| `POST /api/auth/register` | Public |

## Database Setup

### Prerequisites
- MySQL 8.0+ installed and running

### Create Database
```sql
CREATE DATABASE ecommerce_db;

Application Properties

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

How to Run
Backend
Clone the repository

Open in VS Code or IntelliJ IDEA

Update application.properties with your MySQL credentials

Run EcommerceApiApplication.java (green play button)

The API will start at http://localhost:8080

Frontend
Open signup.html or login.html with Live Server

Register a new user account

Login with your credentials

Browse products (guest access available)

API Endpoints
Public Endpoints (No Auth Required)
Method	Endpoint	Description
GET	/api/v1/products	Get all products
GET	/api/v1/products/{id}	Get product by ID
POST	/api/auth/register	Register a new user
Protected Endpoints (ADMIN only)
Method	Endpoint	Description
POST	/api/v1/products	Create new product
PUT	/api/v1/products/{id}	Update product
DELETE	/api/v1/products/{id}	Delete product
Sample Requests
Register a User (POST)
URL: http://localhost:8080/api/auth/register
Body:

{
    "username": "newuser",
    "password": "password123",
    "role": "ROLE_USER"
}

Response (201 Created):

{
    "message": "User registered successfully!"
}

Login
Use Basic Authentication with username and password. The server sets a JSESSIONID cookie.

Create Product (ADMIN only)
URL: http://localhost:8080/api/v1/products
Headers: Content-Type: application/json
Auth: Basic Auth (admin credentials)
Body:

{
    "name": "New Product",
    "description": "Product description",
    "price": 1999,
    "category": "Electronics",
    "stockQuantity": 10,
    "imageUrl": "product.jpg"
}

Error Responses
Authentication Failed (401)

{
    "status": 401,
    "error": "Unauthorized"
}

Access Denied (403)

{
    "status": 403,
    "error": "Access Denied",
    "message": "You do not have permission to access this resource"
}

Validation Error (400)

{
    "status": 400,
    "error": "Validation Failed",
    "validationErrors": {
        "name": "Product name is required",
        "price": "Price must be greater than 0"
    }
}

Database Schema
Users Table
Column	Type	Description
id	BIGINT	Primary key (auto-increment)
username	VARCHAR(255)	Unique username
password	VARCHAR(255)	BCrypt hashed password
role	VARCHAR(50)	ROLE_USER or ROLE_ADMIN
Products Table
Column	Type	Description
id	BIGINT	Primary key (auto-increment)
name	VARCHAR(100)	Product name
description	VARCHAR(500)	Product description
price	DOUBLE	Product price
category	VARCHAR(100)	Category name
stock_quantity	INT	Available stock
image_url	VARCHAR(255)	Product image filename
Screenshots
Database Users Table
https://screenshots/screenshot-db-users.png

User Registration
https://screenshots/screenshot-register.png

User Login
https://screenshots/screenshot-login.png

Unauthorized DELETE (403)
https://screenshots/screenshot-delete-403.png

Frontend Integration
The frontend (separate repository) provides:

Signup page (signup.html) - User registration

Login page (login.html) - User authentication

Products page - Displays products with user greeting and logout button

Credentials are stored in sessionStorage and sent with each API request using Basic Authentication.

Known Limitations
Session-based authentication (not stateless JWT)

No password reset functionality

No email verification

Basic frontend UI (no framework)

Author
Balanquit, Junel M. & Balansag, Geraldine R.

Submission Date
May 2026