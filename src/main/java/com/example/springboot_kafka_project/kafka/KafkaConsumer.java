package com.example.springboot_kafka_project.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class KafkaConsumer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics="javaguides", groupId="myGroup")
    public void consume(String message)
    {
    LOGGER.info(String.format("Message received %s",message));
    }
}
