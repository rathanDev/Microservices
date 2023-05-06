package com.example.paymentservice.service;

import com.example.paymentservice.jpa.Payment;
import com.example.paymentservice.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment create(Payment payment) {
        return paymentRepo.save(payment);
    }

    public List<Payment> findAll() {
        return paymentRepo.findAll();
    }

}
