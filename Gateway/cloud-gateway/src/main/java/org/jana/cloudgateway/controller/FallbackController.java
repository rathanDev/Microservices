package org.jana.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/order")
    public Mono<String> orderFallback() {
        return Mono.just("Order service taking too long to respond!");
    }

    @GetMapping("/payment")
    public Mono<String> paymentFallback() {
        return Mono.just("Payment service taking too long to respond!");
    }

}
