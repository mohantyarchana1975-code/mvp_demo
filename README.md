# MVP Backend (Java 21 + Spring Boot 3.2.x)

## Run locally
```bash
mvn spring-boot:run
# Swagger: http://localhost:8080/swagger-ui.html
# H2 console: http://localhost:8080/h2
```
Demo login (POST `/api/auth/login`):
```json
{ "username": "admin", "password": "admin123" }
```
Use the returned `token` as `X-Token` header for other endpoints.

## Build JAR
```bash
mvn -DskipTests package
java -jar target/mvp-backend-0.0.1-SNAPSHOT.jar
```

## Docker
```bash
docker build -t mvp-backend .
docker run -p 8080:8080 mvp-backend
```
