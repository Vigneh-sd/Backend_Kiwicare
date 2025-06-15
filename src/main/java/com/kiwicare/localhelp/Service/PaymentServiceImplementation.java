package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.DTO.PaymentRequest;
import com.kiwicare.localhelp.Entity.BookingModel;
import com.kiwicare.localhelp.Entity.PaymentModel;
import com.kiwicare.localhelp.Entity.UserModel;
import com.kiwicare.localhelp.Respository.BookingRepository;
import com.kiwicare.localhelp.Respository.PaymentRepository;
import com.kiwicare.localhelp.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PaymentServiceImplementation implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public PaymentModel makePayment(PaymentRequest request) {
        UserModel user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        BookingModel booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        boolean alreadyPaid = paymentRepository.existsByBookingId(booking.getId());
        if (alreadyPaid) {
            throw new IllegalStateException("You have already paid for this booking");
        }

        PaymentModel payment = new PaymentModel();
        payment.setUser(user);
        payment.setBooking(booking);
        payment.setAmount(request.getAmount());
        payment.setPaymentTime(LocalDateTime.now());
        payment.setStatus("PAID");

        return paymentRepository.save(payment);
    }

    @Override
    public List<PaymentModel> getPaymentsByUserId(Long userId) {
        return paymentRepository.findWithBookingAndVolunteerByUserId(userId)
                .stream()
                .sorted(Comparator.comparing(PaymentModel::getPaymentTime).reversed())
                .toList();
    }

}
