package com.example.gdsc_hw03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hi")
    public String Hello(){
        return "Hello, Spring";
    }
}
