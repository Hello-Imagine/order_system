package com.images.controller;

import com.images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    /**
     * 图片上传
     * @param file 图片文件
     * @return json 图片的 url
     * @throws IOException e
     */
    @PostMapping("/images/upload")
    public Map<String, String> imageUpload(MultipartFile file) throws IOException {
        return imageService.upload(file);
    }

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @PostMapping("/images/upload2")
    public String imageUpload2(String message, MultipartFile file) throws IOException {
        System.out.println(message);
        System.out.println(file.getSize());
        return "hello world";
    }

}
