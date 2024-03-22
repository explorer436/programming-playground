package com.mycompany.camelmicroserviceb.controller;

import com.mycompany.camelmicroserviceb.model.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange findConversionValue(@PathVariable String from, @PathVariable String to) {
        return CurrencyExchange.builder().id(10001L).from(from).to(to).conversionMultiple(BigDecimal.TEN).build();
    }
}
