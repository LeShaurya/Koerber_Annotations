package com.demoapp.services;

import com.demoapp.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    KafkaTemplate<String, Order>kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public void sendMessage(Order order) {
        kafkaTemplate.send(topicName, order);
    }
}
