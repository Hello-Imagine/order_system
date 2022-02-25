package com.example1.controller;

import com.example1.service.DemoService;
import com.example1.service.FoodService;
import com.example1.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonResponse list(){

        return JsonResponse.success(null);
    }
}
