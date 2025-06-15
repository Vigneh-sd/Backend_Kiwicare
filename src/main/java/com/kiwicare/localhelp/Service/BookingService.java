package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.DTO.BookingRequest;
import com.kiwicare.localhelp.Entity.BookingModel;

import java.util.List;

public interface BookingService {
    BookingModel createBooking(BookingRequest request);
    List<BookingModel> getBookingsByUserId(long userId);
    List<BookingModel> getBookingsByVolunteerId(long volunteerId);
    List<BookingModel> getAllBookings();
    void cancelBooking(Long bookingId);


}
