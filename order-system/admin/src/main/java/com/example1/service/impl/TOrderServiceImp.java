package com.example1.service.impl;

import com.example1.entity.Food;
import com.example1.entity.TOrder;
import com.example1.entity.User;
import com.example1.mapper.TOrderMapper;
import com.example1.service.TOrderService;
import com.example1.vo.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TOrderServiceImp implements TOrderService {
    @Autowired
    TOrderMapper tOrderMapper;

    @Override
    public boolean delete(Integer id) {
        return tOrderMapper.delete(id);
    }

    @Override
    public boolean freeOrder(Integer id) {
        return tOrderMapper.freeOrder(id);
    }

    @Override
    public List<OrderView> listAll() {
        return tOrderMapper.listAll();
    }

    @Override
    public OrderView getById(Integer id) {
        return tOrderMapper.getById(id);
    }

    @Override
    public List<OrderView> selectByTableOrID(Integer id) {
        return tOrderMapper.selectByTableOrID(id);
    }

    @Override
    public List<OrderView> selectByDate(Date date) {
        return tOrderMapper.selectByDate(date);
    }

    @Override
    public List<Food> listOrderFood(Integer id) {
        return tOrderMapper.listOrderFood(id);
    }

    @Override
    public User selectOrderWaiter(Integer id) {
        return tOrderMapper.selectOrderWaiter(id);
    }
}
