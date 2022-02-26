package com.example1.mapper;

import com.example1.entity.Food;
import com.example1.entity.TOrder;
import com.example1.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

@Mapper
public interface TOrderMapper {
    boolean delete(Integer id);

    boolean freeOrder(Integer id);

    List<TOrder> listAll();

    TOrder getById(Integer id);

    List<TOrder> selectByTableOrID(Integer id);

    List<TOrder> selectByDate(Date date);

    List<Food> listOrderFood(Integer id);

    User selectOrderWaiter(Integer id);
}
