package com.example1.controller;

import com.example1.service.HistoryService;
import com.example1.utils.JsonResponse;
import com.example1.vo.HistoryFood;
import com.example1.vo.HistorySale;
import com.example1.vo.HistoryWaiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HistroryController {

    @Autowired
    HistoryService histroryService;

    //显示前十菜品
    @RequestMapping("/showTopFood")
    public JsonResponse showTopFood(){
        List<HistoryFood> result = new ArrayList<>();
        result = histroryService.showTopFood();
        if(result == null){
            return JsonResponse.failure("fail to access food");
        }
        return JsonResponse.success(result);
    }

    //显示前十服务员
    @RequestMapping("/showTopWaiter")
    public JsonResponse showTopWaiter(){
        List<HistoryWaiter> result = new ArrayList<>();
        result = histroryService.showTopWaiter();
        if(result == null){
            return JsonResponse.failure("fail to access food");
        }
        return JsonResponse.success(result);
    }

    //今日总销售额
    @RequestMapping("/today_sales")
    public JsonResponse todaySales(){
        Integer result = 0;
        result = histroryService.todaySales();
        return JsonResponse.success(result);
    }

    //近M天销售额变化
    @PostMapping("/sale_change")
    public JsonResponse saleChange(String start, String end){
        List<HistorySale> result = new ArrayList<>();
        result = histroryService.sales(start,end);
        if(result == null){
            return JsonResponse.failure("error");
        }
        return JsonResponse.success(result);
    }


    //近M天销量变化
    @PostMapping("/sale_num_change")
    public JsonResponse saleNumChange(String start, String end){
        List<HistorySale> result = new ArrayList<>();
        result = histroryService.saleNum(start,end);
        if(result == null){
            return JsonResponse.failure("error");
        }
        return JsonResponse.success(result);
    }
}
