package com.springboot.microservice.soapserver.service;

import com.springboot.microservice.CurrencyConversionDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@Service
@Slf4j
public class RestTemplateService {
    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrencyConversionDto getCurrencyConversion(CurrencyConversionDto currencyConversionDto) {

        HttpEntity<CurrencyConversionDto> requestBody = new HttpEntity<>(currencyConversionDto);
        CurrencyConversionDto result = restTemplate.postForEntity("http://localhost:8000/exchangevalue/retrieve",
                requestBody, CurrencyConversionDto.class).getBody();

        return result;
    }

}