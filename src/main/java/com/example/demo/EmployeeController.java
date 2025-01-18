package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@ConditionalOnProperty(name = "employee.api.enabled", havingValue = "true", matchIfMissing = false)
public class EmployeeController {
    @GetMapping("/employee")
    public String employeeName() {
        return "Employee Get Returns!";
    }
}
