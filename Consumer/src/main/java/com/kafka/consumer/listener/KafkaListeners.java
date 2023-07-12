package com.kafka.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "testTopic1", groupId = "groupId")
    void listener(String msg) {
        System.out.println("Listener received data: ".concat(msg));
    }
}
