package com.kiwicare.localhelp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime fromTime;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime toTime;

    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private UserModel volunteer;
}
