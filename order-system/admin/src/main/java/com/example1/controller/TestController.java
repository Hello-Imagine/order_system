package com.example1.controller;

import com.example1.service.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private ImageService imageService;

    @GetMapping("/test")
    public String test() {
        return imageService.test();
//        return "hello world";
    }

}
