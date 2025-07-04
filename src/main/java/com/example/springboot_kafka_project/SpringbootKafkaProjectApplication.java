package com.example.springboot_kafka_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"om.example.springboot_kafka_project.config", "com.example.springboot_kafka_project.controller", "com.example.springboot_kafka_project.kafka"})
public class SpringbootKafkaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaProjectApplication.class, args);
	}

}
