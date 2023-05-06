package com.example.orderservice.common;

import com.example.orderservice.jpa.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Order order;
    private int amount;
    private String transactionId;

}
