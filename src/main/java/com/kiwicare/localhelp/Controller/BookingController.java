package com.kiwicare.localhelp.Controller;

import com.kiwicare.localhelp.DTO.BookingRequest;
import com.kiwicare.localhelp.Entity.BookingModel;
import com.kiwicare.localhelp.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'VOLUNTEER')")
    public ResponseEntity<String> createBooking(@RequestBody BookingRequest request) {
        BookingModel booking = bookingService.createBooking(request);
        if (booking != null) {
            return ResponseEntity.ok("Booking successful!");
        } else {
            return ResponseEntity.badRequest().body("Booking failed: Volunteer not available or already booked.");
        }
    }
    @GetMapping("/admin/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BookingModel>> getAllBookingsForAdmin() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }


    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('USER', 'VOLUNTEER')")
    public ResponseEntity<List<BookingModel>> getBookingsByUserId(@PathVariable("userId") long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }

    @GetMapping("/volunteer/{volunteerId}")
    @PreAuthorize("hasAnyRole('USER', 'VOLUNTEER')")
    public ResponseEntity<List<BookingModel>> getBookingsByVolunteerId(@PathVariable("volunteerId") long volunteerId) {
        return ResponseEntity.ok(bookingService.getBookingsByVolunteerId(volunteerId));
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('VOLUNTEER') or hasRole('ADMIN')")
    public ResponseEntity<String> cancelBooking(@PathVariable("id") Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking cancelled and refund processed (if paid).");
    }

}
