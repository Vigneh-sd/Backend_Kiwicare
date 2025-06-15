package com.kiwicare.localhelp.Respository;

import com.kiwicare.localhelp.Entity.AvailabilityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<AvailabilityModel, Long> {

    List<AvailabilityModel> findByVolunteerId(long volunteerId);

    void deleteAllByVolunteerId(long volunteerId);

    // Find all availabilities for a given date
    List<AvailabilityModel> findByDate(LocalDate date);
    
    @Query("SELECT COUNT(b) > 0 FROM BookingModel b WHERE b.volunteer.id = :volunteerId AND b.date = :date AND " +
    	       "((b.timeSlot >= :from AND b.timeSlot < :to) OR (b.timeSlot = :from))")
    	boolean existsByVolunteerIdAndDateAndTimeOverlap(
    	        @Param("volunteerId") Long volunteerId,
    	        @Param("date") LocalDate date,
    	        @Param("from") LocalTime from,
    	        @Param("to") LocalTime to
    	);

}
