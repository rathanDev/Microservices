package com.example.orderservice.controller;

import com.example.orderservice.common.TransactionRequest;
import com.example.orderservice.common.TransactionResponse;
import com.example.orderservice.jpa.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public TransactionResponse create(@RequestBody TransactionRequest req) {
        return orderService.create(req);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

}
