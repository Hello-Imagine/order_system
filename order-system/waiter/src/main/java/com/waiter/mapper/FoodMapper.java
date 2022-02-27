package com.waiter.mapper;

import com.waiter.entity.Food;
import com.waiter.vo.TakeFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

    List<Food> selectAll();

    List<Food> queryById(String query);

    List<Food> queryByName(String query);

    Food queryFood(Integer food_id);

    List<TakeFood> queryTakeFood(Integer user_id);
}
