package com.example1.service;

import com.example1.entity.Food;
import com.example1.entity.FoodSales;

import java.util.List;

public interface FoodService{
    boolean add(Food food);

    boolean deleteById(Integer id);

    boolean update(Food food);

    boolean setAvailable(Integer id);

    boolean setNotAvailable(Integer id);

    List<Food> listAll();

    Food selectById(Integer id);

    List<Food> listByCategory(Integer category);

    List<Food> selectByPrice(Float min, Float max);

    List<Food> fuzzySearchByName(String query);

    List<FoodSales> selectTop3Food();
}
