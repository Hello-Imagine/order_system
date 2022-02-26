package com.example1.service.impl;

import com.example1.entity.Food;
import com.example1.entity.FoodSales;
import com.example1.mapper.FoodMapper;
import com.example1.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;

    @Override
    public boolean add(Food food) {
        return foodMapper.add(food);
    }

    @Override
    public boolean deleteById(Integer id) {
        return foodMapper.deleteById(id);
    }

    @Override
    public boolean update(Food food) {
        return foodMapper.update(food);
    }

    @Override
    public boolean setAvailable(Integer id) {
        return foodMapper.setAvailable(id);
    }

    @Override
    public boolean setNotAvailable(Integer id) {
        return foodMapper.setNotAvailable(id);
    }

    @Override
    public List<Food> listAll() {
        return foodMapper.listAll();
    }

    @Override
    public Food selectById(Integer id) {
        return foodMapper.selectById(id);
    }

    @Override
    public List<Food> listByCategory(Integer category) {
        return foodMapper.listByCategory(category);
    }

    @Override
    public List<Food> selectByPrice(Float min, Float max) {
        return foodMapper.selectByPrice(min, max);
    }

    @Override
    public List<Food> fuzzySearchByName(String query) {
        return foodMapper.fuzzySearchByName(query);
    }

    @Override
    public List<FoodSales> selectTop3Food() {
        return foodMapper.selectTop3Food();
    }
}
