package com.kitchen.controller;

import com.kitchen.entity.TOrder;
import com.kitchen.service.OrderService;
import com.kitchen.vo.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/back-kitchen/unfinished")
    public JsonResponse unfinished(){
        List<TOrder> result = orderService.showUnfinished();
        if(result==null){
            return JsonResponse.msg(1,"成功");
        }
        return JsonResponse.success(result);
    }

    @RequestMapping("/back-kitchen/finished")
    public JsonResponse finished(){
        List<TOrder> result = orderService.showFinished();
        if(result==null){
            return JsonResponse.msg(1,"成功");
        }
        return JsonResponse.success(result);
    }
}
