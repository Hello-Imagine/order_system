package com.waiter.service.impl;

import com.waiter.entity.TOrder;
import com.waiter.mapper.OrderMapper;
import com.waiter.service.OrderService;
import com.waiter.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Integer createOrder(Integer user_id, Integer table_id, Integer num_people, String memo, Float total_price) {
        //设置status 为未支付
        Integer status = 0;
        //设置create_time 为当前时间
        Date create_time = new Date();

        TOrder tOrder = new TOrder();
        tOrder.setUserId(user_id);
        tOrder.setTableId(table_id);
        tOrder.setNumPeople(num_people);
        tOrder.setMemo(memo);
        tOrder.setTotalPrice(total_price);
        tOrder.setCreateTime(create_time);
        tOrder.setStatus(status);

        orderMapper.insertOrder(tOrder);
        return tOrder.getOrderId();
    }

    @Override
    public void createAssociation(Integer order_id, Integer food_id, Integer num_food) {
        //设置status 为还没炒
        Integer status = 0;
        //设置delivery 为未传菜
        Integer delivery = 0;
        orderMapper.insertAssociation(order_id,food_id,num_food,status,delivery);
    }

    @Override
    public List<TOrder> showOrderToPay(Integer user_id) {
        return orderMapper.selectOrderToPay(user_id);
    }

    @Override
    public OrderDetails showOrderDetails(Integer order_id) {

        OrderDetails orderDetails = new OrderDetails();
        TOrder tOrder = orderMapper.queryById(order_id);
        List<FoodStatistic> foodStatisticList = orderMapper.selectOrderFood(order_id);
        orderDetails.setTOrder(tOrder);
        orderDetails.setFoodList(foodStatisticList);

        return orderDetails;
    }

    @Override
    public void payOrder(Integer order_id) {

        orderMapper.updateOrder(order_id);

    }

}
