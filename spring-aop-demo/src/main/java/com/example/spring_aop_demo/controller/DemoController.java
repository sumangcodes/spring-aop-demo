package com.example.spring_aop_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
class DemoController {
    @GetMapping("/greet")
    public String greet() {
        return "Hello, World!";
    }

    @GetMapping("/error")
    public String throwError() {
        throw new RuntimeException("An error occurred!");
    }
}
