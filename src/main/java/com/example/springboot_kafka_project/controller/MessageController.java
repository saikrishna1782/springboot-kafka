package com.example.springboot_kafka_project.controller;
import com.example.springboot_kafka_project.kafka.KafkaConsumer;
import com.example.springboot_kafka_project.kafka.KafkaProducer;


import com.example.springboot_kafka_project.model.Form;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    private KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper=new ObjectMapper();

    public MessageController(KafkaProducer kafkaProducer)
    {
        this.kafkaProducer = kafkaProducer;
    }

    //http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message)
    {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
    @PostMapping("/publishFormData")
    public ResponseEntity<String> publishFormData(@RequestBody Form formData)
    {


        kafkaProducer.sendData( formData);
        LOGGER.info("RECEIVED FORM DATA: {}", formData);

        return ResponseEntity.ok("form data receivced");
    }

}
//line added by feature/branch2 in controller