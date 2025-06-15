// --- Updated AvailabilityServiceImplementation.java ---

package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.Entity.AvailabilityModel;
import com.kiwicare.localhelp.Entity.BookingModel;
import com.kiwicare.localhelp.Entity.Role;
import com.kiwicare.localhelp.Entity.UserModel;
import com.kiwicare.localhelp.Respository.AvailabilityRepository;
import com.kiwicare.localhelp.Respository.BookingRepository;
import com.kiwicare.localhelp.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AvailabilityServiceImplementation implements AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> getAvailableVolunteersByTimeRange(LocalDate date, LocalTime fromTime, LocalTime toTime) {
        return userRepository.findAll().stream()
            .filter(user -> user.getRole() == Role.VOLUNTEER)
            .filter(volunteer -> {
                // ✅ Check availability
                boolean isAvailable = availabilityRepository.findByVolunteerId(volunteer.getId()).stream()
                    .anyMatch(avail ->
                        avail.getDate().equals(date) &&
                        Boolean.TRUE.equals(avail.getAvailable()) &&
                        avail.getFromTime() != null &&
                        avail.getToTime() != null &&
                        !fromTime.isBefore(avail.getFromTime()) &&
                        !toTime.isAfter(avail.getToTime())
                    );

                // ❌ Check if already booked in that time range
                boolean isBooked = bookingRepository.existsByVolunteerIdAndDateAndTimeOverlap(
                        volunteer.getId(), date, fromTime, toTime);

                return isAvailable && !isBooked;
            })
            .toList();
    }


    @Override
    public List<AvailabilityModel> getAvailabilityByVolunteerId(long volunteerId) {
        return availabilityRepository.findByVolunteerId(volunteerId);
    }

    @Override
    public AvailabilityModel addAvailability(AvailabilityModel availability) {
        Long volunteerId = availability.getVolunteer().getId();
        LocalDate date = availability.getDate();
        LocalTime from = availability.getFromTime();
        LocalTime to = availability.getToTime();

        boolean conflict = bookingRepository.existsByVolunteerIdAndDateAndTimeOverlap(volunteerId, date, from, to);
        if (conflict) {
            throw new IllegalStateException("You already have a booking that overlaps with this availability");
        }

        return availabilityRepository.save(availability);
    }

    // Stub methods for unused interface methods
    @Override
    public List<UserModel> getAvailableVolunteers(String date, String timeSlot) { return null; }
    @Override
    public List<UserModel> getAvailableVolunteers(LocalDate date, LocalTime timeSlot) { return null; }
    @Override
    public List<AvailabilityModel> addAvailability(List<AvailabilityModel> availability) { return availabilityRepository.saveAll(availability); }
    @Override
    public void deleteAvailabilityByVolunteerId(long volunteerId) {}
    @Override
    public AvailabilityModel updateAvailability(long volunteerId, com.kiwicare.localhelp.Entity.DaysOfWeek day, Boolean available) { return null; }
    @Override
    public AvailabilityModel updateAvailability(long volunteerId, com.kiwicare.localhelp.Entity.DaysOfWeek day, Boolean available, LocalDate date, LocalTime timeSlot) { return null; }
}
