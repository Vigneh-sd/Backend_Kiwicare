package com.kiwicare.localhelp.Controller;

import com.kiwicare.localhelp.DTO.PaymentRequest;
import com.kiwicare.localhelp.Entity.PaymentModel;
import com.kiwicare.localhelp.Service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequest request) {
        paymentService.makePayment(request);
        return ResponseEntity.ok("Payment successful!");
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<PaymentModel>> getPaymentsByUserId(@PathVariable("userId") long userId) {
        return ResponseEntity.ok(paymentService.getPaymentsByUserId(userId));
    }
}
