package com.scaler.productservice1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class HelloController {
    @GetMapping("/greet")
    public String sayHello() {
        return "Hello World";
    }
}
