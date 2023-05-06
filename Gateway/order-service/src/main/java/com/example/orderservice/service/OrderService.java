package com.example.orderservice.service;

import com.example.orderservice.common.Payment;
import com.example.orderservice.common.TransactionRequest;
import com.example.orderservice.common.TransactionResponse;
import com.example.orderservice.jpa.Order;
import com.example.orderservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse create(TransactionRequest req) {

        Order order = req.getOrder();

        Payment paymentReq = req.getPayment();
        paymentReq.setOrderId(order.getId());
        paymentReq.setAmount(order.getPrice());

        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment", paymentReq, Payment.class);

        orderRepo.save(order);

        TransactionResponse res = new TransactionResponse(order, order.getPrice(), paymentResponse.getTransactionId());
        return res;
    }

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

}
