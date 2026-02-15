package com.eazybytes.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/home")
    public String demo() {
        return "Hello, World!";
    }
}
