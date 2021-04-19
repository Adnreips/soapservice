package com.springboot.microservice.soapserver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SoapServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoapServerApplication.class, args);
    }

}

