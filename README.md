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


## 📁 Folder Structure

```bash
Backend_Kiwicare/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/kiwicare/localhelp/
│   │   │       ├── config/
│   │   │       │   └── CorsConfig.java
│   │   │       ├── Controller/
│   │   │       │   ├── AdminController.java
│   │   │       │   ├── AuthController.java
│   │   │       │   ├── AvailabilityController.java
│   │   │       │   ├── BookingController.java
│   │   │       │   ├── MessageController.java
│   │   │       │   └── UserController.java
│   │   │       ├── DTO/
│   │   │       │   ├── AvailabilityRequest.java
│   │   │       │   ├── BookingRequest.java
│   │   │       │   ├── MessageRequest.java
│   │   │       │   └── PaymentRequest.java
│   │   │       ├── Entity/
│   │   │       │   ├── AvailabilityModel.java
│   │   │       │   ├── BookingModel.java
│   │   │       │   ├── DaysOfWeek.java
│   │   │       │   ├── MessageModel.java
│   │   │       │   ├── PaymentModel.java
│   │   │       │   └── Role.java
│   │   │       ├── Exception/
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       ├── Repository/
│   │   │       │   ├── AvailabilityRepository.java
│   │   │       │   ├── BookingRepository.java
│   │   │       │   ├── MessageRepository.java
│   │   │       │   ├── PaymentRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       ├── Security/
│   │   │       │   ├── CustomUserDetailsService.java
│   │   │       │   ├── JwtAuthenticationFilter.java
│   │   │       │   ├── JwtUtil.java
│   │   │       │   ├── RefreshTokenStore.java
│   │   │       │   └── SecurityConfig.java
│   │   │       ├── Service/
│   │   │       │   ├── AdminService.java
│   │   │       │   ├── AvailabilityService.java
│   │   │       │   ├── BookingService.java
│   │   │       │   ├── MessageService.java
│   │   │       │   ├── PaymentService.java
│   │   │       │   └── UserService.java
│   │   │       └── LocalHelpApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       ├── application.properties
│   │       └── application-prod.properties
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
