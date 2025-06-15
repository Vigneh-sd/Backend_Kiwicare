package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.Entity.AvailabilityModel;
import com.kiwicare.localhelp.Entity.DaysOfWeek;
import com.kiwicare.localhelp.Entity.UserModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AvailabilityService {
    List<UserModel> getAvailableVolunteers(String date, String timeSlot);
    List<UserModel> getAvailableVolunteers(LocalDate date, LocalTime timeSlot);
    List<UserModel> getAvailableVolunteersByTimeRange(LocalDate date, LocalTime fromTime, LocalTime toTime);
    AvailabilityModel addAvailability(AvailabilityModel availability);
    List<AvailabilityModel> addAvailability(List<AvailabilityModel> availability);
    List<AvailabilityModel> getAvailabilityByVolunteerId(long volunteerId);
    void deleteAvailabilityByVolunteerId(long volunteerId);
    AvailabilityModel updateAvailability(long volunteerId, DaysOfWeek day, Boolean available);
    AvailabilityModel updateAvailability(long volunteerId, DaysOfWeek day, Boolean available, LocalDate date, LocalTime timeSlot);
}
