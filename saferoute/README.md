# 🛡️ SafeRoute - Real-Time Risk-Aware Navigation System

SafeRoute is an intelligent navigation application designed to provide users with optimal routing based on real-time safety scores, risk density maps, and live hazard broadcasts. Built with a robust Java Spring Boot backend and an interactive Leaflet frontend.

---

## 🌟 Key Features

* **Risk-Aware Routing:** Calculates safe paths dynamically by parsing proximity to incident-dense areas.
* **Real-Time Hazard Broadcasting:** Leverages WebSockets for instant, low-latency road risk updates across clients.
* **Dual Routing Engine:** Allows users to toggle seamlessly between **Safest Route** and **Fastest Route**.
* **Interactive Mapping:** Geospatial rendering with custom UI controls using Leaflet.js.

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot, Spring WebSocket, REST APIs
* **Frontend:** JavaScript (ES6+), HTML5, CSS3, Leaflet.js
* **Routing Services:** OpenRouteService API
* **Build Tool:** Maven

---

## 🚀 Getting Started

### Prerequisites
* Java 17 or higher installed
* Maven installed

### Installation & Setup

1. **Clone the Repository**
   ```bash
   git clone [https://github.com/YOUR_USERNAME/SafeRoute.git](https://github.com/YOUR_USERNAME/SafeRoute.git)
   cd SafeRoute