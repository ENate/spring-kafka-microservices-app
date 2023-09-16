package com.minejava.orderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;


/**
 * In this class we'll add all the manual configuration required for Observability to
 * work.
 */
@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class ManualConfiguration {
    private final KafkaTemplate kafkaTemplate;

    @PostConstruct
    void setup() {
        this.kafkaTemplate.setObservationEnabled(true);
    }
}
