package com.example1.mapper;

import com.example1.entity.Food;
import com.example1.entity.FoodSales;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

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

    boolean setLike(Integer id);

    boolean setNotLike(Integer id);
}
