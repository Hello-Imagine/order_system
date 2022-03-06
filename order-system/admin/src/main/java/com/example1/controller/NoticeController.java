package com.example1.controller;

import com.example1.service.NoticeService;
import com.example1.utils.JsonResponse;
import com.example1.vo.NoticeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    //发送公告
    @PostMapping("/admin/notice")
    public JsonResponse sendNotice(NoticeRequest noticeRequest){

        noticeService.sendNotice(noticeRequest.getTitle(),noticeRequest.getContent());

        return JsonResponse.msg(1,"success");
    }
}
