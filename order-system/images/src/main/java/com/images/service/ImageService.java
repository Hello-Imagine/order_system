package com.images.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImageService {
    Map<String, String> upload(MultipartFile file) throws IOException;
}
