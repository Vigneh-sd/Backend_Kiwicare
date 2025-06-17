# KiwiCare Backend ☕️

The **KiwiCare Backend** is a secure, modular REST API built using **Spring Boot**.  
It powers a volunteer help platform where users can request help, volunteers can manage availability, and admins can oversee the system.  
The backend handles authentication, role-based access, bookings, messaging, and payments.

The KiwiCare Backend is a secure and scalable REST API built using Spring Boot, designed to power a full-stack volunteer help platform. 
It supports JWT-based authentication, role-based access (user, volunteer, admin), and modular services for booking, messaging, availability, 
payments, and admin controls. It follows clean architecture principles with separate layers for Controller, Service, Repository, and Security.

---

## 🔐 Key Features

- Role-based access: User, Volunteer, Admin  
- JWT authentication with refresh tokens  
- Booking system with date-time filtering  
- Volunteer availability management  
- Secure messaging between users and volunteers  
- Payment processing and history tracking  
- Admin controls to manage users and bookings  
- Global exception handling  
- CORS configured for frontend integration

---

## 🛠 Tech Stack

- Java  
- Spring Boot  
- Spring Security + JWT  
- JPA + Hibernate  
- MySQL
- REST APIs

---

## 🌐 Frontend Repository

➡️ **KiwiCare Frontend (React):**  
https://github.com/Vigneh-sd/Kiwicare_frontend.git

---

## 🎥 Live Demo

📺 **Watch Full Project Demo:**  
https://your-demo-video-link

---

## 👨‍💻 Author

Developed by **Vignesh Subramaniam**  
📧 Connect with me on LinkedIn:  
https://www.linkedin.com/in/vigneshsubramaniam07/


# 🥝 KiwiCare – Complete Project Explanation

## 🧠 Overview

**KiwiCare** is a full-stack volunteer help platform that enables users to request assistance, volunteers to offer availability, and admins to manage the entire system. The platform is built with:

- **Frontend:** React.js + Tailwind CSS
- **Backend:** Spring Boot + Spring Security + JWT
- **Database:** MySQL-compatible (PlanetScale / Neon / Local)

The application supports **role-based dashboards** with different capabilities for **Users**, **Volunteers**, and **Admins**.

---

## 🔐 1. User Registration & Login

### ✅ Registration
- Users can register with:
  - Name
  - Email
  - Password
  - Location
  - Role (User / Volunteer / Admin)
- Backend stores the user securely:
  - Passwords hashed with BCrypt
  - Role-based logic is stored and used to control access

### 🔓 Login
- JWT access and refresh tokens are issued on successful login.
- Role is decoded from the token.
- Redirects user to the appropriate dashboard (User, Volunteer, Admin).

---

## 👤 2. Features for Regular Users

### 🏠 User Dashboard
- View welcome message, role, and quick-access features.

### 🙋‍♂️ Request Help
- Select a date and time range (from-time, to-time).
- Search for available volunteers based on those times.
- Book a volunteer by confirming the request.

### 📅 My Bookings
- View all current and past bookings.
- Cancel a booking if needed (with automatic refund).

### 💬 Messaging
- Chat with the assigned volunteer in a WhatsApp-style thread.
- View received and sent messages.

### 💳 Make Payment
- Pay for confirmed bookings via a simple payment form.
- Store booking ID and amount.

### 📂 Payment History
- View all successful and refunded payments.
- Track payment status (Completed / Cancelled / Refunded).

---

## 🤝 3. Features for Volunteers

### 🏠 Volunteer Dashboard
- Personalized dashboard for volunteers with quick navigation.

### ⏰ Set Availability
- Choose a specific date and provide from-time and to-time range.
- Stored in the database and used for user help searches.

### 📅 My Bookings
- View all bookings assigned by users.
- Prepare to offer help based on booked slots.

### 💬 Messaging
- Chat directly with users via the internal messaging system.
- View received and sent messages.

---

## 🛠️ 4. Features for Admin

### 🏠 Admin Dashboard
- Centralized panel with overview and controls.

### 👥 Manage Users & Volunteers
- View all registered users, volunteers, and admins.
- Delete accounts when necessary.

### 📅 View All Bookings
- See every booking made across the platform.
- Track date, time, user, volunteer, and status.

---

## 🧩 Role-Based Access (Backend Logic)

- Secured using Spring Security with `@PreAuthorize` annotations.
- JWT tokens are verified before allowing access to any protected endpoint.
- Role-checking ensures only authorized actions are allowed:
  - Users cannot access admin endpoints.
  - Volunteers cannot access user booking APIs.
  - Admins can manage all accounts and view all bookings.

---

## 🛠 Technologies Used

- **React.js** + **Tailwind CSS** – Frontend
- **Spring Boot**, **Spring Security**, **JWT** – Backend
- **JPA**, **Hibernate**, **MySQL** – Database
- **Axios**, **React Router**, **Toastify**, **JWT Decode** – Frontend tools

---

## ✅ Summary

KiwiCare is a complete role-based web platform that offers real-time help request, booking, chat, and payment features for communities. It is designed to be modular, scalable, and easily extendable for production-ready deployment.

