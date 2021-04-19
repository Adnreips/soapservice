package com.springboot.microservice.soapserver;

import com.springboot.microservice.CurrencyConversionDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@Service
@Slf4j
public class RestTemplateService {

    public CurrencyConversionDto getCurrencyConversion(CurrencyConversionDto currencyConversionDto) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CurrencyConversionDto> requestBody = new HttpEntity<>(currencyConversionDto);
        CurrencyConversionDto result
                = restTemplate.postForEntity("http://localhost:8000/exchangevalue/retrieve", requestBody, CurrencyConversionDto.class).getBody();


        return result;
    }

}