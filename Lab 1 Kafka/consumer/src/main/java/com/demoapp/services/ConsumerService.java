package com.demoapp.services;

import com.demoapp.dto.Order;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Log4j2
@Service
public class ConsumerService {

    @KafkaListener(topics = "orders")
    public void consume(Order order) {
        log.info("Processing: {} at time: {}", order, LocalDateTime.now());
    }
}
