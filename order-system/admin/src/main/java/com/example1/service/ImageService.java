package com.example1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//@Component
@FeignClient("image")
public interface ImageService {

    @GetMapping("/test")
    String test();

}
