package com.gcu.lab1_api.service;

import org.springframework.stereotype.Service;

import com.gcu.lab1_api.dto.HelloResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    public HelloResponse getHello() {
        logger.info("Generating hello message");
        return new HelloResponse("Hello, Spring Boot");
    }
}