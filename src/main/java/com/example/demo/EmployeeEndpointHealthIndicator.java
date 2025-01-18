package com.example.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeeEndpointHealthIndicator implements HealthIndicator {

    private static final String EMPLOYEE_CHECK = "http://localhost:8080/employee";
   
    @Override
    public Health health() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForObject(EMPLOYEE_CHECK, String.class);
            return Health.up().withDetail("Employee API Status", "Available").build();
        } catch (Exception e) {
            return Health.down().withDetail("Employee API Status", "Unavailable").build();
        }
    }
}

