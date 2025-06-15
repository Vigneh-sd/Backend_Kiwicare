package com.kiwicare.localhelp.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageRequest {

    @NotBlank(message = "Content cannot be blank")
    private String content;

    @NotNull(message = "Sender ID is required")
    @Min(value = 1, message = "Sender ID must be positive")
    private Long senderId;

    @NotNull(message = "Receiver ID is required")
    @Min(value = 1, message = "Receiver ID must be positive")
    private Long receiverId;
}