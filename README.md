# 🎓 Education Platform API

REST API developed for user management and authentication in an educational platform.

## 📌 Purpose
This project simulates a corporate backend system with access control, data persistence, and layered architecture, following best practices in Java backend development.

## 🚀 Technologies
- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- Flyway (database versioning)
- MySQL
- Maven

## 🧠 Architecture
The application follows a layered architecture:
- Controller (REST endpoints)
- Service (business logic)
- Repository (data access)
- Entity / DTO

## 🔐 Security
- Authentication and authorization with Spring Security
- User-based access control

## 🗄️ Database
- Relational modeling using JPA
- Database versioning with Flyway

## 📡 Main Endpoints
- User registration
- Authentication
- Account recovery

## 🧪 Tests
- Unit tests with JUnit
- TDD-based approach

📈 Future Improvements
- Microservices architecture
- Messaging integration
- Cloud deployment

👨‍💻 Author
- Harlan Goyana
- Java Backend Developer

## ⚙️ How to Run
```bash
git clone https://github.com/hvalmer/apirest-education-platform
cd apirest-education-platform
mvn spring-boot:run
