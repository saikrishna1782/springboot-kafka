package com.example.springboot_kafka_project.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
//this class is to create a kafka topic in kafka cluster using springboot application
@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createNewTopic() {
        return TopicBuilder.name("javaguides")
                .build();
    }
}
