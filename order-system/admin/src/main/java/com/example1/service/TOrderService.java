package com.example1.service;

import com.example1.entity.Food;
import com.example1.entity.TOrder;
import com.example1.entity.User;
import com.example1.vo.OrderView;

import java.sql.Date;
import java.util.List;

public interface TOrderService {
    boolean delete(Integer id);

    boolean freeOrder(Integer id);

    List<OrderView> listAll();

    OrderView getById(Integer id);

    List<OrderView> selectByTableOrID(Integer id);

    List<OrderView> selectByDate(Date date);

    List<Food> listOrderFood(Integer id);

    User selectOrderWaiter(Integer id);
}
