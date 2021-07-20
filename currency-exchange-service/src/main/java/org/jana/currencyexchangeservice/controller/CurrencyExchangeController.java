package org.jana.currencyexchangeservice.controller;

import org.jana.currencyexchangeservice.bean.CurrencyExchange;
import org.jana.currencyexchangeservice.repo.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchange exchange(@PathVariable String fromCurrency,
                                     @PathVariable String toCurrency) {
//        CurrencyExchange ce = new CurrencyExchange(1000L, fromCurrency, toCurrency, BigDecimal.valueOf(65.15));

        CurrencyExchange ce = currencyExchangeRepo.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);

        if (ce == null) {
            throw new RuntimeException("Unable to find data");
        }

        String port = environment.getProperty("local.server.port");
        ce.setEnv(port);

        return ce;
    }

}
