package com.waiter.controller;

import com.waiter.JsonResponse;
import com.waiter.entity.TOrder;
import com.waiter.service.FoodService;
import com.waiter.service.OrderService;
import com.waiter.vo.OrderDetails;
import com.waiter.vo.OrderRequestBody;
import com.waiter.vo.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    FoodService foodService;

    //点餐页面
//    @RequestMapping("/waiter/order")
//    public JsonResponse order(@RequestParam(required = false) String query){
//        if(query == null){
//            List<Food> result = foodService.showAllFood();
//            if(result==null){
//                return JsonResponse.failure("数据库中不存在菜品信息");
//            }
//            return JsonResponse.success(result);
//        }
//        else{
//            List<Food> result = foodService.showFood(query);
//            if(result==null){
//                return JsonResponse.failure("未找到菜品");
//            }
//            return JsonResponse.success(result);
//        }
//    }

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

}
