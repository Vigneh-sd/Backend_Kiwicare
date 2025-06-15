package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.DTO.PaymentRequest;
import com.kiwicare.localhelp.Entity.PaymentModel;

import java.util.List;

public interface PaymentService {
    PaymentModel makePayment(PaymentRequest request);
    List<PaymentModel> getPaymentsByUserId(Long userId);
}
