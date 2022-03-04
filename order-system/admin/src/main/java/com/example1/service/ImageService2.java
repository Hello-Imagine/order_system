package com.example1.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService2 {
    String uploadImage(MultipartFile file) throws IOException;
}
