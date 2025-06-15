package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.DTO.BookingRequest;
import com.kiwicare.localhelp.Entity.BookingModel;
import com.kiwicare.localhelp.Entity.PaymentModel;
import com.kiwicare.localhelp.Entity.Role;
import com.kiwicare.localhelp.Entity.UserModel;
import com.kiwicare.localhelp.Respository.BookingRepository;
import com.kiwicare.localhelp.Respository.PaymentRepository;
import com.kiwicare.localhelp.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImplementation implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public BookingModel createBooking(BookingRequest request) {
        UserModel user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserModel volunteer = userRepository.findById(request.getVolunteerId())
                .filter(u -> u.getRole() == Role.VOLUNTEER)
                .orElseThrow(() -> new RuntimeException("Volunteer not found or not a volunteer"));

        LocalDate date = request.getDate();
        LocalTime timeSlot = request.getTimeSlot();

        boolean isAlreadyBooked = bookingRepository
                .findByVolunteerIdAndDateAndTimeSlot(volunteer.getId(), date, timeSlot)
                .isPresent();

        if (isAlreadyBooked) {
            throw new RuntimeException("Volunteer is already booked at the given time");
        }

        BookingModel booking = new BookingModel();
        booking.setUser(user);
        booking.setVolunteer(volunteer);
        booking.setDate(date);
        booking.setTimeSlot(timeSlot);

        return bookingRepository.save(booking);
    }

    @Override
    public List<BookingModel> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<BookingModel> getBookingsByUserId(long userId) {
        return bookingRepository.findAll()
                .stream()
                .filter(b -> b.getUser().getId() == userId)
                .toList();
    }

    @Override
    public List<BookingModel> getBookingsByVolunteerId(long volunteerId) {
        return bookingRepository.findAll()
                .stream()
                .filter(b -> b.getVolunteer().getId() == volunteerId)
                .toList();
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Optional<BookingModel> optionalBooking = bookingRepository.findById(bookingId);

        if (optionalBooking.isEmpty()) {
            throw new RuntimeException("Booking with ID " + bookingId + " not found.");
        }

        BookingModel booking = optionalBooking.get();

        // Refund + detach booking reference from payment
        List<PaymentModel> payments = paymentRepository.findAll()
                .stream()
                .filter(p -> p.getBooking() != null && p.getBooking().getId().equals(bookingId))
                .toList();

        for (PaymentModel payment : payments) {
            payment.setStatus("REFUNDED");
            payment.setBooking(null); 
            paymentRepository.save(payment);
        }

        bookingRepository.delete(booking);
    }

}
