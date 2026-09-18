package com.gcu.lab1_api.service;

import org.springframework.stereotype.Service;

import com.gcu.lab1_api.dto.HelloResponse;

@Service
public class HelloService {
    public HelloResponse getHello() {
        return new HelloResponse("Hello, Spring Boot");
    }
}