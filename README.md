# 🍽️ Restaurant Reservation System

A RESTful API built with Spring Boot that manages table reservations for a restaurant.  
Admins can configure tables and weekly opening hours, while users can request reservations based on availability.

---

## ⚙️ Tech Stack
- Java 17
- Spring Boot (Spring Web, Spring Data JPA)
- PostgreSQL
- Lombok
- Postman for API testing
- Swagger UI for API documentation

---

## 🧩 Main Entities

### 🪑 Restaurant Table
- Name (e.g. "Table 1")
- Capacity (number of people)
- Indoor / Outdoor

### 🕒 Opening Hours
- Day of week
- Opening time / Closing time
- Option to mark day as closed

### 📅 Reservation
- Name / Email / Phone
- Date / Duration (Start time - End time)
- Party size
- System checks availability & assigns table if possible

---

## 🔗 API Endpoints

### Tables (Admin)
- `POST /api/restaurant/admin/table` — Create a new table
- `GET /api/restaurant/admin/tables` — Get all tables
- `GET /api/restaurant/admin/table/{id}` — Get a specific table
- `PUT /api/restaurant/admin/table/{id}` — Update a specific table
- `DELETE /api/restaurant/admin/table/{id}` — Delete a specific table

### Opening Hours (Admin / Read-only for Users)
- `POST /api/restaurant/admin/opening_hours` — Create new opening hours
- `GET /api/restaurant/opening_hours` — View opening hours
- `PUT /api/restaurant/admin/opening_hours/{day}` — Update opening hours
- `DELETE /api/restaurant/admin/opening_hours` — Delete all opening hours

### Reservations (User)
- `POST /api/restaurant/reservation` — Create a reservation (system auto-assigns a table)
- `GET /api/restaurant/admin/reservations` — View all reservations
- `DELETE /api/restaurant/admin/reservations` — Delete all reservations
- `DELETE /api/restaurant/admin/reservation/{id}` — Delete a specific reservation

---

## 📌 Assumptions
- No authentication implemented (admin/user separation is theoretical for now)
- A reservation is valid only if there is an available table at the requested time
- Opening hours and Tables are editable only by admins

---

## 📖 API Documentation

Once the application is running, you can explore the API using Swagger UI:

- [Swagger UI](http://localhost:8080/swagger-ui/index.html)

---

## 🔮 Future Enhancements
- Add JWT-based authorization
- Add Docker support for deployment

---

## 👤 Author
- Antonis Mourtzakis
- antmourtzakis@gmail.com
- [LinkedIn Profile](https://www.linkedin.com/in/antonis-mourtzakis/)
