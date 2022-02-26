package com.example1.controller;

import com.example1.service.FoodService;
import com.example1.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    //显示所有菜品信息
    @RequestMapping("/list")
    public JsonResponse list(){
        return JsonResponse.success(foodService.listAll());
    }

    //根据 id 显示菜品信息
}
