package com.example1.mapper;

import com.example1.entity.Food;
import com.example1.entity.TOrder;
import com.example1.entity.User;
import com.example1.vo.OrderView;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

@Mapper
public interface TOrderMapper {
    boolean delete(Integer id);

    boolean freeOrder(Integer id);

    List<OrderView> listAll();

    OrderView getById(Integer id);

    List<OrderView> selectByTableOrID(Integer id);

    List<OrderView> selectByDate(Date date);

    List<Food> listOrderFood(Integer id);

    User selectOrderWaiter(Integer id);
}
