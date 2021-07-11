package org.jana.currencyexchangeservice.controller;

import org.jana.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchange exchange(@PathVariable String fromCurrency,
                                     @PathVariable String toCurrency) {
        return new CurrencyExchange(1000L, fromCurrency, toCurrency, BigDecimal.valueOf(65.15));
    }

}
