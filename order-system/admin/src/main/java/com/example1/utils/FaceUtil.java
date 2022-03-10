package com.example1.utils;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FaceUtil {
    private static volatile FaceUtil faceClient;
    private final AipFace client;

    // appid: 25738931
    // apikey: cGdHFXPrSrGdEXkVViH6mGEG
    // secret key: RGPcnZKq9jtYTPVVSqXMOn6g6AqHlMuy
    private FaceUtil(String APP_ID, String API_KEY, String SECRET_KEY) {
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    }

    public static FaceUtil getInstance(String APP_ID, String API_KEY, String SECRET_KEY) {
        if (faceClient == null) {
            synchronized (FaceUtil.class) {
                if (faceClient == null) {
                    faceClient = new FaceUtil(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return faceClient;
    }

    /**
     * 人脸检测
     * @param image 输入图片
     * @return 包含人脸返回true，否则返回false
     */
    public boolean faceDetect(String image) {
        // options是检查项参数
        HashMap<String, String> options = new HashMap<>();
        options.put("max_face_num", "1"); // max_face_num检测的时候摄像头只能有一张人脸

        // 检测人脸，调用AipFace类汇总的detect方法，来检测人脸
        JSONObject result = client.detect(image, "BASE64", options);

        System.out.println(result.toString());


        Object resultObj = result.get("result");

        // 没有检测到人脸
        if (resultObj == null || resultObj.toString().equals("null")) {
            return false;
        }
        // 检测到人脸了{"result":{"face_num":1, },}
        JSONObject faceObj = (JSONObject) resultObj;
        return faceObj.getInt("face_num") == 1;
    }

    /**
     * 人脸比对
     * @param image1 比对的两张图
     * @param image2 比对的两张图
     * @return 判断为相同返回true 否则返回false
     */
    public boolean faceContrast(String image1, String image2) { // base64编码格式的图片

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应

        MatchRequest req1 = new MatchRequest(image1, "BASE64");
        MatchRequest req2 = new MatchRequest(image2, "BASE64");
        ArrayList<MatchRequest> requests = new ArrayList<>();
        requests.add(req1);
        requests.add(req2);

        // 可以检测图片中是否有人脸
        // client.detect(image, imageType, options)

        JSONObject res = client.match(requests); // AipFace类的对象中的match接口 实现人脸比对
        System.out.println(res.toString());

        Object object = res.get("result");
        if (object == null || object.toString().equals("null")) {
            return false;
        } else {
            res = (JSONObject) object;
            double result = res.getDouble("score"); // score里存放了比对结果
            return result >= 70;
        }
    }
}