package com.kiwicare.localhelp.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentRequest {

    @NotNull(message = "User ID is required")
    @Min(value = 1, message = "User ID must be positive")
    private Long userId;

    @NotNull(message = "Booking ID is required")
    @Min(value = 1, message = "Booking ID must be positive")
    private Long bookingId;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be positive")
    private double amount;
}