package com.demoapp.controllers;

import com.demoapp.dto.Order;
import com.demoapp.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private ProducerService producerService;

    @GetMapping
    public void send(@RequestBody Order order) {
        producerService.sendMessage(order);
    }
}
