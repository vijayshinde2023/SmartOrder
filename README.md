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

