package com.example.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DemoEndpointHealthIndicator implements HealthIndicator {

    private static final String DEMO_CHECK = "http://localhost:8080/demo";
   
    @Override
    public Health health() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForObject(DEMO_CHECK, String.class);
            return Health.up().withDetail("DEMO API Status", "Available").build();
        } catch (Exception e) {
            return Health.down().withDetail("DEMO API Status", "Unavailable").build();
        }
    }
}

