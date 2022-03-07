package com.waiter.controller;

import com.alibaba.fastjson.JSONObject;
import com.waiter.JsonResponse;
import com.waiter.entity.TOrder;
import com.waiter.service.FoodService;
import com.waiter.service.OrderService;
import com.waiter.util.GoEasyUtil;
import com.waiter.vo.OrderDetails;
import com.waiter.vo.OrderRequestBody;
import com.waiter.vo.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    FoodService foodService;

    //确认点单 注意传入的 foodList 是菜品的id和对应数量的 map
    @PostMapping("/waiter/take_order")
    public JsonResponse takeOrder(@RequestBody OrderRequestBody orderRequestBody){
        //创建订单
        Integer order_id = orderService.createOrder(orderRequestBody.getUserId(),
                orderRequestBody.getTableId(), orderRequestBody.getNumPeople(),
                orderRequestBody.getMemo(), orderRequestBody.getTotalPrice());
        //创建关联表
        for (OrderView a : orderRequestBody.getOrderViews()) {
            orderService.createAssociation(order_id,a.getFoodId(),a.getNumFood());
        }

        // TODO: Zep add
        // 长连接
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderId", order_id);
        jsonObject.put("tableId", orderRequestBody.getTableId());
        jsonObject.put("totalPrice", orderRequestBody.getTotalPrice());
        jsonObject.put("numPeople", orderRequestBody.getNumPeople());
        GoEasyUtil.publish("back-kitchen", jsonObject.toJSONString());

        return JsonResponse.msg(1,"成功");
    }

    //待结算订单
    @RequestMapping("/waiter/to_pay")
    public JsonResponse toPay(Integer user_id){
//        System.out.println(user_id);
        List<TOrder> result = orderService.showOrderToPay(user_id);
        return JsonResponse.success(result);
    }

    //订单结算详情
    @RequestMapping("/waiter/order_details")
    public JsonResponse orderDetails(Integer order_id){
        OrderDetails result = orderService.showOrderDetails(order_id);
        if(result==null){
            return JsonResponse.failure("订单已删除");
        }
        return JsonResponse.success(result);
    }

    //订单结算
    @PostMapping("/waiter/to_pay/pay")
    public JsonResponse pay(@RequestParam Map<String, String> data){
        Integer order_id = Integer.parseInt(data.get("order_id"));
        System.out.println(order_id);
        orderService.payOrder(order_id);
        return JsonResponse.msg(1,"成功");
    }

}
