package com.waiter.mapper;

import com.waiter.entity.TOrder;
import com.waiter.vo.FoodStatistic;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {

    TOrder queryById(Integer order_id);

    Integer insertOrder(TOrder tOrder);

    void insertAssociation(Integer order_id, Integer food_id, Integer num_food, Integer status, Integer delivery);

    List<TOrder> selectOrderToPay(Integer user_id);

    List<FoodStatistic> selectOrderFood(Integer order_id);

    void updateOrder(Integer order_id, Date finishTime);
}
