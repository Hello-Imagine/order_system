package com.example1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient("image")
public interface ImageService {

    @PostMapping("/")
    Map<String, String> getUrl(MultipartFile file);

}
