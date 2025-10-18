# AboutMe API

A simple Spring Boot REST API that serves profile information with a random cat fact.

## Features

- 📋 Profile endpoint exposing user information
- 🐱 Integration with Cat Fact API for random cat facts
- ⚡ Built with Spring Boot 3.5.4 and Java 21

## API Endpoint

### Get Profile
```
GET /me
```

**Response:**
```json
{
  "status": "success",
  "user": {
    "email": "your.email@example.com",
    "name": "Your Name",
    "stack": "Java / Spring Boot"
  },
  "timestamp": "2025-10-18T21:30:40.562Z",
  "fact": "A random cat fact here"
}
```

## Tech Stack

- **Java 21**
- **Spring Boot 3.5.4**
- **Maven**
- **Lombok**
- **Spring WebFlux** (for reactive HTTP calls)

### Prerequisites
- Java 21
- Maven 3.6+

### Setup

1. Clone the repository
```bash
git clone <your-repo-url>
cd aboutme
```

2. Set environment variables
```bash
export USER_EMAIL="your.email@example.com"
export USER_NAME="Your Name"
export USER_STACK="Java / Spring Boot"
```

3. Run the application
```bash
mvn spring-boot:ru
```

The API will be available at `http://localhost:8080/me`

### Build Configuration:
- **Build Command:** `mvn clean package -DskipTests`
- **Start Command:** `java -Dserver.port=$PORT -jar target/aboutme-api.jar`