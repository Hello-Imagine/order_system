package com.example2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo2Controller {

    @GetMapping("/")
    public String test1() {
        return "hello world:8081";
    }

}
