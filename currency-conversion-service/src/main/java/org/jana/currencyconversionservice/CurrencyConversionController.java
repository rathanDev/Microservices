package org.jana.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable long quantity) {

        // return new CurrencyConversion(10001L, from, to, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, "dev");

        Map<String, String> uriVariableMap = new HashMap<>();
        uriVariableMap.put("from", from);
        uriVariableMap.put("to", to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
                .getForEntity(
                        "http://localhost:8000/currency-exchange/from/USD/to/INR",
                        CurrencyConversion.class,
                        uriVariableMap);
        return responseEntity.getBody();
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,
                                                               @PathVariable String to,
                                                               @PathVariable long quantity) {
        CurrencyConversion conversion = proxy.exchange(from, to);
        return conversion;
    }

}
