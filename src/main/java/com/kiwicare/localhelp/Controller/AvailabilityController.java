package com.kiwicare.localhelp.Controller;

import com.kiwicare.localhelp.Entity.AvailabilityModel;
import com.kiwicare.localhelp.Entity.UserModel;
import com.kiwicare.localhelp.Respository.UserRepository;
import com.kiwicare.localhelp.Service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<String> addAvailability(@RequestBody AvailabilityModel availability) {
        availabilityService.addAvailability(availability);
        return ResponseEntity.ok("Availability added successfully!");
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<String> saveAvailability(@RequestBody AvailabilityModel availability) {
        // Set volunteer reference manually using ID
        Long volunteerId = availability.getVolunteer() != null ? availability.getVolunteer().getId() : null;

        if (volunteerId == null) {
            return ResponseEntity.badRequest().body("Volunteer ID is missing in request.");
        }

        UserModel volunteer = userRepository.findById(volunteerId)
            .orElseThrow(() -> new RuntimeException("Volunteer not found"));

        availability.setVolunteer(volunteer);  // 💥 This is critical
        availabilityService.addAvailability(availability);

        return ResponseEntity.ok("Availability saved successfully!");
    }


    @GetMapping("/get/{volunteerId}")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<List<AvailabilityModel>> getAvailabilityByVolunteerId(@PathVariable("volunteerId") long volunteerId) {
        return ResponseEntity.ok(availabilityService.getAvailabilityByVolunteerId(volunteerId));
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UserModel>> getAvailableVolunteers(
            @RequestParam("date") String dateStr,
            @RequestParam("fromTime") String fromStr,
            @RequestParam("toTime") String toStr) {

        LocalDate date = LocalDate.parse(dateStr);
        LocalTime from = LocalTime.parse(fromStr);
        LocalTime to = LocalTime.parse(toStr);

        return ResponseEntity.ok(availabilityService.getAvailableVolunteersByTimeRange(date, from, to));
    }
}