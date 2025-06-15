package com.kiwicare.localhelp.Respository;

import com.kiwicare.localhelp.Entity.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {

    boolean existsByBookingId(Long bookingId);

    @Query("SELECT p FROM PaymentModel p " +
           "LEFT JOIN FETCH p.booking b " +
           "LEFT JOIN FETCH b.volunteer " +
           "WHERE p.user.id = :userId")
    List<PaymentModel> findWithBookingAndVolunteerByUserId(@Param("userId") Long userId);
}
