package com.kafka.producer;

import com.kafka.producer.config.ProducerTopics;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(ProducerTopics.TEST_TOPIC_1, "Hello from producer");

            future.whenComplete((input, exception) -> {
                if (exception != null) {
                    System.out.println("Exception occured");
                    exception.printStackTrace();
                } else {
                    System.out.println(input);
                }
            });
        };

    }
}
