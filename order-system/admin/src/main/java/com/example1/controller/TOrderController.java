package com.example1.controller;

import com.example1.entity.Food;
import com.example1.entity.TOrder;
import com.example1.entity.User;
import com.example1.service.TOrderService;
import com.example1.utils.JsonResponse;
import com.example1.vo.OrderView;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class TOrderController {
    @Autowired
    TOrderService tOrderService;

    //删除订单
    @RequestMapping("/delete")
    public JsonResponse deleteOrder(Integer id){
        if(tOrderService.delete(id))
            return JsonResponse.success(null);
        else return JsonResponse.failure("No such an order");
    }

    //直接免单
    @RequestMapping("/free")
    public JsonResponse freeOrder(Integer id){
        if(tOrderService.freeOrder(id))
            return JsonResponse.success(null);
        else return JsonResponse.failure("No such an order");
    }

    //显示正在进行的订单
    @RequestMapping("/todoList")
    public JsonResponse todoList(){
        return JsonResponse.success(tOrderService.todoList());
    }

    //显示已完成的订单
    @RequestMapping("/finishList")
    public JsonResponse finishList(){
        return JsonResponse.success(tOrderService.finishList());
    }

    //根据ID显示订单信息
    @RequestMapping("/get_by_id")
    public JsonResponse getById(Integer id){
        OrderView orderView = tOrderService.getById(id);
        if(orderView != null)
            return JsonResponse.success(orderView);
        else
            return JsonResponse.failure("No such an order");
    }

    //根据桌号或者订单编号搜索
    @RequestMapping("/select_by_table_or_id")
    public JsonResponse selectByTableOrID(Integer id){
        // 如果输入查询条件为空，返回所有数据
        if(id == null)
            return JsonResponse.success(tOrderService.listAll());
        // 如果输入条件不为空
        List<OrderView> list = tOrderService.selectByTableOrID(id);
        return JsonResponse.success(list);
    }

    //显示订单相关菜品，点菜服务员，订单基本信息
    @RequestMapping("/all_detail_info")
    public JsonResponse listAllDetailInfo(Integer id){
        //相关菜品
        List<Food> foodList = tOrderService.listOrderFood(id);
        //点菜服务员
        User waiter = tOrderService.selectOrderWaiter(id);
        //订单基本信息
//        TOrder order = tOrderService.getById(id);

//        return JsonResponse.success(new DetailInfo(foodList, waiter, order));
        return JsonResponse.failure("test");
    }

    //根据订单创建日期查询订单
    @RequestMapping("/select_by_date")
    public JsonResponse selectByDate(Date date){
        List<OrderView> list = tOrderService.selectByDate(date);
        if(list != null)
            return JsonResponse.success(list);
        else
            return JsonResponse.failure("No such an order");
    }

    @Data
    @ToString
    private class DetailInfo{
        List<Food> foodList;
        User waiter;
        TOrder order;

        public DetailInfo(List<Food> foodList, User waiter, TOrder order) {
            this.foodList = foodList;
            this.waiter = waiter;
            this.order = order;
        }
    }
}
