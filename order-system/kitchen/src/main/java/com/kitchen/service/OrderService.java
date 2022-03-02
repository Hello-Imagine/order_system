package com.kitchen.service;

import com.kitchen.entity.TOrder;

import java.util.List;

public interface OrderService {

    //显示未出餐订单
    List<TOrder> showUnfinished();

    //显示已出餐订单
    List<TOrder> showFinished();
}
