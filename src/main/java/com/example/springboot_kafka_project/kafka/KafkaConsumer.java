package com.example.springboot_kafka_project.kafka;

import com.example.springboot_kafka_project.model.Form;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class KafkaConsumer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics="javaguides", groupId="myGroup")
    public void consume(String message)
    {
    LOGGER.info(String.format("Message received %s",message));
    }

    @KafkaListener(topics = "formdata", groupId = "my-group")
    public void consumeFormData(String message) {
        try {
            LOGGER.info("Received JSON from Kafka: {}", message);

            // Deserialize JSON string back to Form object
            Form formData = objectMapper.readValue(message, Form.class);

            LOGGER.info("Deserialized Form Data: {}", formData);
            // You can now process formData (e.g., save to DB)
        } catch (Exception e) {
            LOGGER.error("Failed to deserialize JSON", e);
        }
    }
}
