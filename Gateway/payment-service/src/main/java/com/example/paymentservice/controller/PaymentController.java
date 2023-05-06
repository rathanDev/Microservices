package com.example.paymentservice.controller;

import com.example.paymentservice.jpa.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentService.create(payment);
    }

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.findAll();
    }

}
