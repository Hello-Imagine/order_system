package com.example1.service.impl;

import com.example1.service.ImageService2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class ImageService2Impl implements ImageService2 {
    /**
     * 图片上传
     * @param file 图片文件
     * @return json 图片的 url
     * @throws IOException e
     */
    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        String imageName = getImageName() + ".png";
        file.transferTo(new File("/test/images/" + imageName));
        return "47.108.225.54:9090/img/" + imageName;
    }

    /**
     * 根据当前的时间戳生成图片名称
     * @return 图片名称
     */
    private String getImageName() {
        Date date = new Date();
        return String.valueOf(date.getTime());
    }
}
