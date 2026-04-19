# E-Commerce Service

A RESTful e-commerce backend service built with Spring Boot 4.0.5 and Java 21.

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Web MVC**
- **Maven**

## Getting Started

### Prerequisites

- Java 21+
- Maven 3.9+

### Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

The application starts on `http://localhost:8080` by default.

## API Reference

### User APIs

#### Create User

```bash
curl -X POST '{host}/user' \
  --header 'Content-Type: application/json' \
  --data '{
    "userId": "abcd_1235",
    "name": "First Last",
    "age": "30",
    "gender": "M",
    "phone": "9876543210",
    "email": "test@test.com"
}'
```

### Order APIs

#### Create Order

```bash
curl -X POST '{host}/order' \
  --header 'Content-Type: application/json' \
  --data '{
    "id": "order_1",
    "userId": "abcd_1235",
    "productDetails": [
        {
            "id": "prod_1",
            "name": "tommy toy",
            "sku": "sku_1"
        }
    ]
}'
```

#### Get Order

```bash
curl '{host}/order/order_1/abcd_1235'
```

> Replace `{host}` with your server URL (e.g., `http://localhost:8080`).
