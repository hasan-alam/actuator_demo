package com.example.demo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty(name = "demo.api.enabled", havingValue = "true", matchIfMissing = false)
public class DemoController {
    @GetMapping("/demo")
    public String sayHello() {
        return "Hello World!";
    }
}
