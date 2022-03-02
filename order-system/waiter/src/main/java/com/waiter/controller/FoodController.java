package com.waiter.controller;

import com.waiter.JsonResponse;
import com.waiter.entity.Food;
import com.waiter.service.FoodService;
import com.waiter.vo.TakeFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    @RequestMapping("/waiter/food")
    public JsonResponse showFood(@RequestParam(required = false) String query){
        if(query == null){
            List<Food> result = foodService.showAllFood();
            if(result==null){
                return JsonResponse.failure("数据库中不存在菜品信息");
            }
            return JsonResponse.success(result);
        }
        else{
            List<Food> result = foodService.showFood(query);
            if(result==null){
                return JsonResponse.failure("未找到菜品");
            }
            return JsonResponse.success(result);
        }
    }

    @RequestMapping("/waiter/food_details")
    public JsonResponse foodDetails(Integer food_id){
        Food result = foodService.showDetails(food_id);
        if(result==null){
            return JsonResponse.failure("菜品信息为空");
        }
        return JsonResponse.success(result);
    }

    //显示传菜消息
    @RequestMapping("/waiter/take_food")
    public JsonResponse takeFood(Integer user_id){
        List<TakeFood> result = foodService.showTakeFood(user_id);
        return JsonResponse.success(result);
    }

    //食物状态由未传菜变成已传菜
    @RequestMapping("/waiter/take_food/update")
    public JsonResponse updateDelivery(Integer order_id, Integer food_id){
        if(order_id == null || food_id ==null){
            return JsonResponse.failure("前端未传入数据");
        }
        foodService.changeDelivery(order_id, food_id);
        return JsonResponse.msg(1,"成功");
    }
}
