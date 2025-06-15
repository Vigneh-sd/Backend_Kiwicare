package com.kiwicare.localhelp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Who made the payment
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    // For which booking this payment was made
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BookingModel booking;

    private double amount;

    private String status;  // Example: "PAID", "FAILED", "REFUNDED"

    private LocalDateTime paymentTime;
}
