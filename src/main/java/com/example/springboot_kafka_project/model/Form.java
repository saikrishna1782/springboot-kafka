package com.example.springboot_kafka_project.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Form
{
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;

}
