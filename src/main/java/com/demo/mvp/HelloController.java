package com.demo.mvp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "✅ Backend is running on Railway!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
