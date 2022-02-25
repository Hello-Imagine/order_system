package com.images.service.impl;

import com.images.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {

    /**
     * 图片上传
     * @param file 图片文件
     * @return json 图片的 url
     * @throws IOException e
     */
    @Override
    public Map<String, String> upload(MultipartFile file) throws IOException {
        Map<String, String> map = new HashMap<>();
        String imageName = getImageName() + ".png";
        file.transferTo(new File("/test/images/" + imageName));
        map.put("imgUrl", "http://47.108.225.54:9090/img/" + imageName);
        return map;
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
