# Ecommerce API - Spring Boot REST API

## Overview
A RESTful API for managing e-commerce products built with Spring Boot.

## Technologies Used
- Java 21
- Spring Boot 4.0.6
- Gradle
- Lombok
- Spring Validation

## How to Run

### Prerequisites
- Java 21 or higher
- VS Code or IntelliJ IDEA

### Steps
1. Clone the repository
2. Open in VS Code
3. Run `EcommerceApiApplication.java` (click green play button)
4. The API will start at `http://localhost:8080`

## API Endpoints

| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET | `/api/v1/products` | Get all products | 200 OK |
| GET | `/api/v1/products/{id}` | Get product by ID | 200 OK, 404 Not Found |
| GET | `/api/v1/products/filter?filterType=category&filterValue=Audio` | Filter products | 200 OK |
| POST | `/api/v1/products` | Create new product | 201 Created, 400 Bad Request |
| PUT | `/api/v1/products/{id}` | Update entire product | 200 OK, 404 Not Found, 400 Bad Request |
| DELETE | `/api/v1/products/{id}` | Delete product | 204 No Content, 404 Not Found |

## Sample Requests

### Create a product (POST)
**URL:** `http://localhost:8080/api/v1/products`

**Headers:** `Content-Type: application/json`

**Body:**
```json
{
    "name": "Smart Watch Pro",
    "description": "Track fitness and heart rate",
    "price": 3999,
    "category": "Wearables",
    "stockQuantity": 10,
    "imageUrl": "watch.jpg"
}

Response (201 Created):

{
    "id": 11,
    "name": "Smart Watch Pro",
    "description": "Track fitness and heart rate",
    "price": 3999,
    "category": "Wearables",
    "stockQuantity": 10,
    "imageUrl": "watch.jpg"
}

Get all products (GET)
URL: http://localhost:8080/api/v1/products

Response (200 OK): Array of all products

Update a product (PUT)
URL: http://localhost:8080/api/v1/products/1

Headers: Content-Type: application/json

Body: (Complete product object)

Delete a product (DELETE)
URL: http://localhost:8080/api/v1/products/11

Response: 204 No Content

Error Responses
Product Not Found (404)

{
    "timestamp": "2026-05-07T...",
    "status": 404,
    "error": "Not Found",
    "message": "Product with ID 99 not found",
    "path": "/api/v1/products/99"
}

Validation Error (400)

{
    "timestamp": "2026-05-07T...",
    "status": 400,
    "error": "Validation Failed",
    "validationErrors": {
        "name": "Product name is required",
        "price": "Price must be greater than 0"
    }
}

Known Limitations
In-memory storage only (data resets when server restarts)

No authentication/authorization

No database connection

Author
Balanquit, Junel M.
Balansag, Geraldine R.