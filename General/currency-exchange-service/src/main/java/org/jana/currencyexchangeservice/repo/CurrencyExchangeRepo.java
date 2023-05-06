package org.jana.currencyexchangeservice.repo;

import org.jana.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

}
