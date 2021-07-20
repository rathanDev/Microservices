package org.jana.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8001")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyConversion exchange(@PathVariable String fromCurrency,
                                       @PathVariable String toCurrency);

}
