package com.gcu.lab1_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.lab1_api.dto.HelloResponse;
import com.gcu.lab1_api.service.HelloService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {

    private final HelloService helloService;
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    @GetMapping("/hello")
    public HelloResponse hello() {
        logger.info("Received request for /hello endpoint");
        return helloService.getHello();
    }
}