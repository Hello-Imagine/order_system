package com.waiter.service;

import com.waiter.entity.Food;
import com.waiter.vo.TakeFood;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FoodService {

    public List<Food> showAllFood();

    public List<Food> showFood(String query);

    Food showDetails(Integer food_id);

    List<TakeFood> showTakeFood(Integer user_id);

    void changeDelivery(Integer order_id, Integer food_id);
}
