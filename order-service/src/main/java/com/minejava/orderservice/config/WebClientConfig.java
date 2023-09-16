package com.minejava.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    @LoadBalanced // adds load balancing capabilities: auto create client load
    // balance service if multiple instances of services is available
    public WebClient.Builder webClientBuiler(){
        return WebClient.builder();
    }
}
