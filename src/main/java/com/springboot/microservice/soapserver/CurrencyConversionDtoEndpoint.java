package com.springboot.microservice.soapserver;

import com.springboot.microservice.soapserver.repository.CurrencyConversionDtoRepository;

import generated.soapserver.com.GetCurrencyConversionDtoRequest;
import generated.soapserver.com.GetCurrencyConversionDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CurrencyConversionDtoEndpoint {
    private static final String NAMESPACE_URI = "http://com.soapserver";

    private CurrencyConversionDtoRepository currencyConversionDtoRepository;

    @Autowired
    public CurrencyConversionDtoEndpoint(CurrencyConversionDtoRepository currencyConversionDtoRepository) {
        this.currencyConversionDtoRepository = currencyConversionDtoRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCurrencyConversionDtoRequest")
    @ResponsePayload
    public GetCurrencyConversionDtoResponse getCurrencyConversionDto(@RequestPayload GetCurrencyConversionDtoRequest request) {
        GetCurrencyConversionDtoResponse response = new GetCurrencyConversionDtoResponse();
        response.setCurrencyConversionDto(currencyConversionDtoRepository.findCurrencyConversionDto(request.getFrom()));
        return response;
    }
}

