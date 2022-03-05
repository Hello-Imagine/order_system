package com.waiter.service;

import com.waiter.entity.TOrder;
import com.waiter.vo.OrderDetails;

import java.util.List;

public interface OrderService {

    public Integer createOrder(Integer user_id, Integer table_id, Integer num_people,
                            String memo, Float total_price);

    //创建order_food表
    public void createAssociation(Integer order_id, Integer food_id, Integer num_food);

    //显示待结算订单
    List<TOrder> showOrderToPay(Integer user_id);

    //显示待结算订单详情
    OrderDetails showOrderDetails(Integer order_id);

    void payOrder(Integer order_id);
}
