package com.example.springboot_kafka_project.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    //constructor based dependency injection
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    //create a method which will use kafka template to send the message
    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("javaguides", message);
    }
}