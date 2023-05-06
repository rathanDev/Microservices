package com.example.paymentservice.repo;

import com.example.paymentservice.jpa.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
