package com.example1.controller;

import com.example1.service.FaceService;
import com.example1.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 人脸识别
 */
@RestController
public class FaceController {

    @Autowired
    private FaceService faceService;

    @PostMapping("/face/upload")
    public JsonResponse<Object> faceUpload(String user_id, MultipartFile file) throws IOException {
        System.out.println(user_id);
        System.out.println(file.getSize());
        return faceService.faceContrast(user_id, file);
//        return JsonResponse.success("null", "成功");
    }

}
