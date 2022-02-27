package com.waiter.controller;

import com.waiter.JsonResponse;
import com.waiter.entity.Message;
import com.waiter.service.MessageService;
import com.waiter.vo.MessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    //查看后厨消息列表
    @RequestMapping("/waiter/message")
    public JsonResponse message(Integer receive_user){
        MessageView result = messageService.showMessage(receive_user);
        if(result == null){
            return JsonResponse.failure("找不到该用户");
        }
        return JsonResponse.success(result);
    }

    //后厨消息详情
    @RequestMapping("/waiter/message_details")
    public JsonResponse messageDetails(Integer message_id){

        Message result = messageService.messagedetails(message_id);
        if(result == null){
            return  JsonResponse.failure("找不到该公告");
        }
        return JsonResponse.success(result);
    }
}
