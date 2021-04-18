package com.springboot.microservice.soapserver.repository;

import generated.soapserver.com.CurrencyConversionDto;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CurrencyConversionDtoRepository {
    private static final Map<String, CurrencyConversionDto> currencyConversionDtoHashMap = new HashMap<>();

    @PostConstruct
    public void initData() {
        CurrencyConversionDto currencyConversionDto = new CurrencyConversionDto();
        currencyConversionDto.setId(1);
        currencyConversionDto.setFrom("USD");
        currencyConversionDto.setTo("INR");
        currencyConversionDto.setConversionMultiple(new BigDecimal("75"));
        currencyConversionDto.setQuantity(new BigDecimal("1"));
        currencyConversionDto.setMultiply(new BigDecimal("75"));
        currencyConversionDto.setPort(1);
        currencyConversionDtoHashMap.put(currencyConversionDto.getFrom(), currencyConversionDto);

    }

    public CurrencyConversionDto findCurrencyConversionDto(String from) {
        Assert.notNull(from, "The CurrencyConversionDto's from must not be null");
        return currencyConversionDtoHashMap.get(from);
    }
}