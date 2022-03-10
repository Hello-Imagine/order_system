package com.example1.controller;

import com.example1.mapper.UserMapper;
import com.example1.service.FaceService;
import com.example1.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * 人脸识别
 */
@RestController
public class FaceController {

    @Autowired
    private FaceService faceService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/face/upload")
    public JsonResponse<Object> faceUpload(String user_id, MultipartFile file) throws IOException {
        System.out.println(user_id);
        System.out.println(file.getSize());
        return faceService.faceContrast(user_id, file);
//        return JsonResponse.success("null", "成功");
    }

    @GetMapping("/test1")
    public String test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/desktop/save/huangyujiao.jpg");
        Base64.Encoder encoder = Base64.getEncoder();
        int available = fileInputStream.available();
        byte[] bytes = new byte[available];
        fileInputStream.read(bytes);
        String image = encoder.encodeToString(bytes);
        fileInputStream.close();
        userMapper.updateUserByUserId(image);
        return "hello world";
    }

}
