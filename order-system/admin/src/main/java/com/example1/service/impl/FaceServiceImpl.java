package com.example1.service.impl;

import com.example1.service.FaceService;
import com.example1.utils.FaceUtil;
import com.example1.utils.JsonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class FaceServiceImpl implements FaceService {

    @Override
    public JsonResponse<Object> faceContrast(MultipartFile file) throws IOException {
        String upload = getBase64FromMultipartFile(file);
        String portrait = getBase64FromUrl();
        FaceUtil faceUtil = FaceUtil.getInstance("25738931", "cGdHFXPrSrGdEXkVViH6mGEG",
                "RGPcnZKq9jtYTPVVSqXMOn6g6AqHlMuy");
        boolean b = faceUtil.faceContrast(upload, portrait);
        System.out.println(b);
        return JsonResponse.success(null, "成功");
    }

    private String getBase64FromMultipartFile(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    private String getBase64FromUrl() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/desktop/save/20220310115525525.png");
        Base64.Encoder encoder = Base64.getEncoder();
        int available = fileInputStream.available();
        byte[] bytes = new byte[available];
        fileInputStream.read(bytes);
        return encoder.encodeToString(bytes);
    }

}
