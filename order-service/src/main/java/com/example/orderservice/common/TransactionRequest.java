package com.example.orderservice.common;

import com.example.orderservice.jpa.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Order order;
    private Payment payment;

    public Payment getPayment() {
        if (payment == null) {
            payment = new Payment();
        }
        return payment;
    }
}
