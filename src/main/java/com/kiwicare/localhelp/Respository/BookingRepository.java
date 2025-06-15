package com.kiwicare.localhelp.Respository;

import com.kiwicare.localhelp.Entity.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Long> {

    // Check if a volunteer is already booked for a specific date and time
    Optional<BookingModel> findByVolunteerIdAndDateAndTimeSlot(Long volunteerId, LocalDate date, LocalTime timeSlot);

    List<BookingModel> findByDateAndTimeSlot(LocalDate date, LocalTime timeSlot);

    
    @Query("SELECT COUNT(b) > 0 FROM BookingModel b WHERE b.volunteer.id = :volunteerId AND b.date = :date AND " +
           "((b.timeSlot >= :from AND b.timeSlot < :to) OR (b.timeSlot = :from))")
    boolean existsByVolunteerIdAndDateAndTimeOverlap(
        @Param("volunteerId") Long volunteerId,
        @Param("date") LocalDate date,
        @Param("from") LocalTime from,
        @Param("to") LocalTime to
    );
}
