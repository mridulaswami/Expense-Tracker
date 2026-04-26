# Expense Tracker API

A RESTful API built with Spring Boot for tracking 
personal income and expenses.

## Tech Stack
- Java 17
- Spring Boot 3.2
- PostgreSQL
- Spring Data JPA
- Maven

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/transactions | Add transaction |
| GET | /api/transactions | Get all transactions |
| GET | /api/transactions/category/{cat} | Filter by category |
| GET | /api/transactions/type/{type} | Filter by type |
| GET | /api/transactions/summary?year=&month= | Monthly summary |
| DELETE | /api/transactions/{id} | Delete transaction |

## Setup
1. Create PostgreSQL database: `finance_tracker`
2. Update `application.properties` with your credentials
3. Run: `mvn spring-boot:run`
4. API runs at: `http://localhost:8080`
