<div align="center">

# 🗺️ SafeRoute

### *Real-Time Safety-Aware Navigation Engine*

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

An intelligent routing engine that calculates dynamic safety scores (0–100) for navigation paths using real-time hazard data and emergency service proximity.

</div>

---

## 🎯 What Makes SafeRoute Different?

Standard navigation systems focus strictly on **shortest distance** or **fastest time**. SafeRoute introduces a dynamic **Safety Layer**:

- **Dynamic Risk Assessment:** Deducts safety points for incidents (accidents, poor lighting, hazards).
- **Emergency Infrastructure Bonus:** Rewards routes passing near police stations and hospitals.
- **Interactive UI & APIs:** Live Leaflet.js map integration backed by high-performance REST endpoints.

---

## 🛠️ Tech Stack

| Component | Technology |
| :--- | :--- |
| **Backend** | Java 21 (LTS), Spring Boot 3.x |
| **Database** | MySQL 8.0 |
| **ORM / JPA** | Spring Data JPA, Hibernate |
| **Frontend** | Leaflet.js, OpenStreetMap, HTML5, JavaScript |
| **Build Tool** | Maven |

---

## 📁 Repository Structure

```text
saferoute/
├── src/main/java/com/example/saferoute/
│   ├── config/          # CORS & WebSockets Configuration
│   ├── controller/      # REST Endpoints (/api/routes)
│   ├── model/           # Data Entities & DTOs
│   ├── repository/      # JPA Data Access Interfaces
│   └── service/         # Safety Calculator & Routing Engine
└── src/main/resources/
    ├── static/          # Web Interface (index.html, JS, CSS)
    └── application.properties
