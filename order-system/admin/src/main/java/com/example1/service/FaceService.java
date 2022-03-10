package com.example1.service;

import com.example1.utils.JsonResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FaceService {

    JsonResponse<Object> faceContrast(String userId, MultipartFile file) throws IOException;

}
