//package com.springboot.microservice.soapserver;
//
//import com.springboot.microservice.CurrencyConversionDto;
//import lombok.Data;
//import ma.glasnost.orika.MapperFacade;
//import ma.glasnost.orika.MapperFactory;
//import ma.glasnost.orika.impl.DefaultMapperFactory;
//import org.springframework.stereotype.Service;
//
//@Service
//@Data
//public class CurrencyConversionDtoFrom {
//    public CurrencyConversionDto toRestFormat(io.soapserver.example.CurrencyConversionDto currencyConversionDto){
//        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//        mapperFactory.classMap(io.soapserver.example.CurrencyConversionDto.class, CurrencyConversionDto.class);
//        MapperFacade mapper = mapperFactory.getMapperFacade();
//        CurrencyConversionDto currencyConversionTo;
//        currencyConversionTo = mapper.map(currencyConversionDto, CurrencyConversionDto.class);
//        return currencyConversionTo;
//
//    }
//    public io.soapserver.example.CurrencyConversionDto fromRestFormat(CurrencyConversionDto currencyConversionDto){
//        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//        mapperFactory.classMap(CurrencyConversionDto.class, io.soapserver.example.CurrencyConversionDto.class);
//        MapperFacade mapper = mapperFactory.getMapperFacade();
//        io.soapserver.example.CurrencyConversionDto currencyConversionTo;
//        currencyConversionTo = mapper.map(currencyConversionDto, io.soapserver.example.CurrencyConversionDto.class);
//        return currencyConversionTo;
//
//    }
//
//
//
//}
