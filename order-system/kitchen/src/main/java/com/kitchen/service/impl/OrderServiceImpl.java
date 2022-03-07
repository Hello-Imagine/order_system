package com.kitchen.service.impl;

import com.kitchen.entity.TOrder;
import com.kitchen.mapper.OrderMapper;
import com.kitchen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<TOrder> showUnfinished() {

        //选出未出餐的订单的id
        //两表联查 food的status !=2 说明存在未烹饪完成的菜品 说明为出餐
        List<Integer> unfinished = orderMapper.selectOrderId();

        //根据order_id 选出order
        return orderMapper.selectUnfinished(unfinished);
    }

    @Override
    public List<TOrder> showFinished() {

        //选出未出餐的订单的id
        //两表联查 food的status !=2 说明存在未烹饪完成的菜品 说明为出餐
        List<Integer> unfinished = orderMapper.selectOrderId();

        //不是未出餐的肯定就是出餐的了 很合理
        return orderMapper.selectFinished(unfinished);
    }
}
