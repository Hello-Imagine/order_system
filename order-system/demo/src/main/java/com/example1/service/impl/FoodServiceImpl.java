package com.example1.service.impl;

import com.example1.entity.Food;
import com.example1.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired


    @Override
    public List<Food> listAll() {
        return null;
    }
}
