# 🛒 SmartOrders Microservices System

SmartOrders is a complete microservices-based architecture built using Spring Boot, Spring Cloud, and Docker. It demonstrates how to build a scalable and modular e-commerce system with service discovery, centralized configuration, API Gateway, distributed tracing, JWT security, and more.

---

## 📦 Microservices Included

| Service            | Description                                           | Port  |
|--------------------|-------------------------------------------------------|--------|
| `discovery-server` | Eureka Service Registry for service discovery         | 8761   |
| `config-server`    | Centralized configuration management (Spring Cloud)   | 8888   |
| `api-gateway`      | Gateway routing with Spring Cloud Gateway             | 8080   |
| `auth-service`     | JWT-based authentication and token generation         | 9005   |
| `user-service`     | Manages user data                                     | 9001   |
| `order-service`    | Manages orders                                        | 9002   |
| `inventory-service`| Handles stock inventory and updates                   | 9003   |
| `zipkin`           | Distributed tracing using Zipkin                      | 9411   |

---

## 🧱 Tech Stack

- Java 21
- Spring Boot 3.x
- Spring Cloud 2025.0.0
- Spring Cloud Gateway (Reactive)
- Spring Security + JWT
- Eureka Discovery Server
- Config Server with Git-backed YAML configs
- OpenFeign + Circuit Breaker (Resilience4j)
- Zipkin + Sleuth for tracing
- Docker + Docker Compose

---

## 📁 Folder Structure


# 🛒 SmartOrders Microservices Architecture

SmartOrders is a **Java-based microservices project** built using Spring Boot 3, Spring Cloud 2025.x, Docker, and JWT. This system demonstrates how to architect and deploy a full-stack enterprise-grade application using modern microservice patterns.

---

## 🌐 Architecture Overview

```text
                                +----------------+
                                |  Postman / UI  |
                                +--------+-------+
                                         |
                                  (JWT Auth Header)
                                         |
                                +--------v-------+
                                |   API Gateway  |
                                | (Spring Cloud) |
                                +--------+-------+
             +---------------------------+--------------------------+
             |            |               |               |         |
     +-------v-----+ +-----v------+ +------v-------+ +-----v------+ 
     | AuthService | | OrderService | | UserService | | Inventory  |
     +-------------+ +--------------+ +--------------+ +-----------+
             \            |               |               /
              \           |         +-----v------+        /
               +----------+---------| Config     |<------+
                          |         |  Server    |       |
                          +---------> Git Config |       |
                                    +------------+       |
                                    +---------------------+
                                    |  Discovery Server    |
                                    |     (Eureka)         |
                                    +----------------------+
```

...

## 👨‍💻 Author

**Vijay Shinde**  
Senior Software Engineer | Java + Spring + Cloud Enthusiast  
📧 [Your Email]  
🌐 GitHub: [github.com/your-profile]  
🔗 LinkedIn: [linkedin.com/in/your-profile]

## 📝 License

This project is open source and licensed under the [MIT License](LICENSE).
