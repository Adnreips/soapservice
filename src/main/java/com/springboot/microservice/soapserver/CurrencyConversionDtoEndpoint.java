package com.springboot.microservice.soapserver;



import com.springboot.microservice.CurrencyConversionDto;

import com.springboot.microservice.GetCurrencyConversionDtoRequest;
import com.springboot.microservice.GetCurrencyConversionDtoResponse;
import com.springboot.microservice.soapserver.service.RestTemplateService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@Service
@Data
public class CurrencyConversionDtoEndpoint {
    private static final String NAMESPACE_URI = "http://springboot.com/microservice";
    private final RestTemplateService restTemplateService;

    @Autowired
    public CurrencyConversionDtoEndpoint(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCurrencyConversionDtoRequest")
    @ResponsePayload
    public GetCurrencyConversionDtoResponse getCurrencyConversionDto(@RequestPayload GetCurrencyConversionDtoRequest request) {

        GetCurrencyConversionDtoResponse response = new GetCurrencyConversionDtoResponse();
        CurrencyConversionDto currencyConversionDto = request.getCurrencyConversionDto();
        CurrencyConversionDto currencyConversionDtoRest = restTemplateService.getCurrencyConversion(currencyConversionDto);
        response.setCurrencyConversionDto(currencyConversionDtoRest);

        return response;
    }
}

