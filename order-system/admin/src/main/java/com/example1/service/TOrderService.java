package com.example1.service;

import com.example1.entity.Food;
import com.example1.entity.TOrder;
import com.example1.entity.User;

import java.sql.Date;
import java.util.List;

public interface TOrderService {
    boolean delete(Integer id);

    boolean freeOrder(Integer id);

    List<TOrder> listAll();

    TOrder getById(Integer id);

    List<TOrder> selectByTableOrID(Integer id);

    List<TOrder> selectByDate(Date date);

    List<Food> listOrderFood(Integer id);

    User selectOrderWaiter(Integer id);
}
