package com.kafka.producer.controllers;

import com.kafka.producer.config.ProducerTopics;
import com.kafka.producer.dtos.SimpleMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @PostMapping("/message")
    public String sendMessage(@RequestBody SimpleMessageDto body) {

        kafkaTemplate.send(ProducerTopics.TEST_TOPIC_1, body.getMessage()).whenComplete((res, exception) -> {
            if (exception != null) {
                System.out.println("Message has been dispatched");
            }
        });
        return "Message sent";
    }
}
