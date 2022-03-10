package com.example1.service.impl;

import com.example1.mapper.UserMapper;
import com.example1.service.FaceService;
import com.example1.utils.FaceUtil;
import com.example1.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class FaceServiceImpl implements FaceService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResponse<Object> faceContrast(String userId, MultipartFile file) throws IOException {
        // 获取用户的本地图片路径
        String path = userMapper.getImagePathByUserId(Integer.parseInt(userId));

        String upload = getBase64FromMultipartFile(file);
        String portrait = getBase64FromPath(path);
        FaceUtil faceUtil = FaceUtil.getInstance("25738931", "cGdHFXPrSrGdEXkVViH6mGEG",
                "RGPcnZKq9jtYTPVVSqXMOn6g6AqHlMuy");
        boolean b = faceUtil.faceContrast(upload, portrait);
        if (b) {
            return JsonResponse.success(null, "成功");
        } else {
            return JsonResponse.failure("失败");
        }
    }

    private String getBase64FromMultipartFile(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    private String getBase64FromPath(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Base64.Encoder encoder = Base64.getEncoder();
        int available = fileInputStream.available();
        byte[] bytes = new byte[available];
        fileInputStream.read(bytes);
        fileInputStream.close();
        return encoder.encodeToString(bytes);
    }

}
