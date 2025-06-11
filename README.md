# ♻️ Food Waste Management System

A full-fledged backend system to manage, track, and redistribute **surplus food** from restaurants, canteens, or individuals to NGOs and needy communities. This project focuses on **real-world impact**, promoting social good with a technically sound architecture.

---

## 🚀 Features

- 🧑‍🍳 **Donor Registration**: Register individuals or businesses donating food
- 🧑‍🤝‍🧑 **NGO Integration**: NGO accounts to receive, schedule, and track pickups
- 🛺 **Pickup Scheduler**: Donors can schedule pickup times and quantities
- 📦 **Inventory of Surplus Items**: Track surplus by type, expiry, location
- 📍 **Geo-Tagging (Ready for extension)**: Location-based matching of NGOs and donors
- 📜 **Donation History**: Full audit trail for compliance & trust
- 🔐 **JWT Auth**: Donors, NGOs, Admin with separate roles
- 📄 **Swagger-enabled Documentation**
- 🧰 **Validation, Logging, Exception Handling**
- 🧪 **Flyway DB Migrations + Structured Logs**

---

## 🧠 Architecture Principles

✅ **Clean Architecture**  
✅ **SOLID**, **KISS**, **DRY**  
✅ Loosely coupled services with clear SoC  
✅ DTOs, Mappers, Services, Controllers in separate modules  
✅ Open for scaling to mobile apps, dashboards, or donation analytics

---

## 🛠️ Tech Stack

| Tech        | Purpose                            |
|-------------|-------------------------------------|
| Java 17     | Core language                      |
| Spring Boot | REST API + Config management        |
| Spring Security + JWT | Authentication & roles    |
| PostgreSQL  | Data storage                        |
| MapStruct   | Mapping entities and DTOs           |
| Swagger     | API testing and documentation       |
| Logback     | Structured Logging                  |
| Flyway      | DB versioning & migrations          |
| Docker      | (Optional) Containerization         |

---

## 📁 Folder Structure

```shell
food-waste-management/
├── controller/
├── dto/
├── entity/
├── service/
├── repository/
├── config/
├── exception/
├── mapper/
├── util/
└── resources/
    └── application.yml

📌 Real-World Highlights
	•	Inspired by actual food tech NGOs like Robin Hood Army & Feeding India
	•	Ideal for scaling into a real platform with SMS/email alerts
	•	Could integrate with Google Maps, Delivery APIs (e.g., Dunzo, Rapido)
	•	Follows robust architectural guidelines for real-world startup use