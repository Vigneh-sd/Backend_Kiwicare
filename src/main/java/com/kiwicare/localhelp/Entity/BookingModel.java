package com.kiwicare.localhelp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User who booked the volunteer
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "password"})
    private UserModel volunteer;


    private LocalDate date;

    private LocalTime timeSlot; // single time slot per booking
}
