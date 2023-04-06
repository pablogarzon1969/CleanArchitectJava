package com.cleanarchitecture.adapter.out.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "test-topic",
            groupId = "group_id")

    // Method
    public void consume(String message)
    {
        // Print statement
        //System.out.println("message = " + message);
        LOGGER.info(String.format("Event message received -> %s",message));
    }
}
