package com.example.springboot_kafka_project.kafka;


import com.example.springboot_kafka_project.model.Form;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    //constructor based dependency injection
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    //create a method which will use kafka template to send the message
    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("javaguides", message);
    }

    public void sendData(Form formData) {
        try {
            String json = objectMapper.writeValueAsString(formData);
            LOGGER.info("Sending JSON to Kafka: {}", json);
            kafkaTemplate.send("formdata", json);
        } catch (Exception e) {
            LOGGER.error("Failed to convert form to JSON", e);
        }
    }
}