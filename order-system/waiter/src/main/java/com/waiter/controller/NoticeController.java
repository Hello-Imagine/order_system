package com.waiter.controller;

import com.waiter.JsonResponse;
import com.waiter.entity.Notice;
import com.waiter.service.NoticeService;
import com.waiter.vo.NoticeView;
import com.waiter.vo.Noticedetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    //服务员界面首页 显示所有公告
    @RequestMapping("/waiter/notice")
    public JsonResponse notice(Integer user_id){
        NoticeView result = noticeService.showNotice(user_id);
        if(result == null){
            return JsonResponse.failure("找不到该用户");
        }
        return JsonResponse.success(result);
    }

    //公告详情
    @RequestMapping("/waiter/notice_details")
    public JsonResponse noticeDetails(Integer notice_id){

        Noticedetails result = noticeService.noticedetails(notice_id);
        if(result == null){
            return  JsonResponse.failure("找不到该公告");
        }
        return JsonResponse.success(result);
    }

    //转换公告状态 已读未读
    @RequestMapping("/waiter/notice/status")
    public JsonResponse changeStatus(Integer notice_id){

        noticeService.changeStatus(notice_id);
        return JsonResponse.msg(1,"成功");
    }

}
