package com.kiwicare.localhelp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailabilityRequest {
    private boolean available;
    private String date;       // Format: yyyy-MM-dd
    private String fromTime;   // Format: HH:mm
    private String toTime;     // Format: HH:mm
}
