package org.jana.currencyexchangeservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    // @Retry(name = "default") // thrice
    // @Retry(name = "sample-api", fallbackMethod = "getHardcodedResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "getHardcodedResponse")
    public String sampleApi() {
        logger.info("Sample api call received");
        // return new RestTemplate()
        //        .getForEntity("http://locahost:8080/some-dummy-url", String.class)
        //        .getBody();
        return "rate-limiter-response";
    }

    public String getHardcodedResponse(Exception e) {
        logger.info("Get hardcoded response");
        return "hardcoded-response";
    }

}
