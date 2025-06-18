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

📺 [Watch Full Project Demo on Google Drive](https://drive.google.com/file/d/1w8ALWM0EP5M7X1GCkgn6r2YikFMj_K2S/view?usp=drivesdk)


---

## 👨‍💻 Author

Developed by **Vignesh Subramaniam**  
📧 Connect with me on LinkedIn:  
https://www.linkedin.com/in/vigneshsubramaniam07/


# 🥝 KiwiCare – Complete Project Explanation

## 🧠 Overview

# 📸 KiwiCare Project Screenshots

### 🚀 Spring Boot Backend Setup

![Springboot.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/Springboot.png)

### 🛠️ React Frontend Setup

![React.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/React.png)

### 👤 Registration Page

![RegistrationPage.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/RegistrationPage.png)

### 🔐 Login Page

![LoginPage.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/LoginPage.png)

### 🏠 Homepage

![Homepage.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/Homepage.png)

---

## 👨‍💻 User Role Screens

### 📍 User Dashboard

![UserDashboard.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/UserDashboard.png)

### 🚑 Request Help

![UserMessages.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/UserMessages.png)

### 📙 Book Help

![UserBookhelp.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/UserBookhelp.png)

### 🗓️ My Bookings

![UserMyBookings.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/UserMyBookings.png)

### 💳 Make Payment

![UserPayment.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/UserPayment.png)

### 📈 Payment History

![UserPaymentHistory.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/UserPaymentHistory.png)

### 📨 Sent Messages

![UserRecievedMessages.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/UserRecievedMessages.png)

---

## 🫏 Volunteer Role Screens

### 📅 Volunteer Dashboard

![VolunteerDashboard.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/VolunteerDashboard.png)

### ⏰ Set Availability

![VolunteerAvailability.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/VolunteerAvailability.png)

### 📩 Received Messages

![VolunteerMessages.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/VolunteerMessages.png)

### 📆 Assigned Bookings

![VolunteerMyBookings.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/VolunteerMyBookings.png)

### 📤 Sent Replies

![VolunteerSentMessages.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/VolunteerSentMessages.png)

---

## 📊 Admin Role Screens

### 🔧 Admin Dashboard

![AdminDashboard.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/AdminDashboard.png)

### 🔧 View All Users

![AdminDashboard\_1.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/AdminDashboard_1.png)

### 🔧 View All Volunteers

![AdminDashboard\_2.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/AdminDashboard_2.png)

### 🔧 View All Bookings & Search User

![AdminDashboard\_3.png](https://raw.githubusercontent.com/Vigneh-sd/Backend_Kiwicare/master/Project_Screenshots/AdminDashboard_3.png)


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



