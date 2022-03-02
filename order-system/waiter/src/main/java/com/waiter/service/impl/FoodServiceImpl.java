package com.waiter.service.impl;

import com.waiter.entity.Food;
import com.waiter.mapper.FoodMapper;
import com.waiter.service.FoodService;
import com.waiter.vo.TakeFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;

    @Override
    public List<Food> showAllFood() {
        return foodMapper.selectAll();
    }

    //显示搜索结果
    @Override
    public List<Food> showFood(String query) {

        //先判断是不是纯数字 是就按ID查找
        if(FoodServiceImpl.isInteger(query)){
            return foodMapper.queryById(query);
        }
        else{
            return foodMapper.queryByName(query);
        }
    }

    @Override
    public Food showDetails(Integer food_id) {

        return foodMapper.queryFood(food_id);
    }

    @Override
    public List<TakeFood> showTakeFood(Integer user_id) {

        return foodMapper.queryTakeFood(user_id);
    }

    @Override
    public void changeDelivery(Integer order_id, Integer food_id) {
        foodMapper.updateDelivery(order_id, food_id);
    }

    //用于判断搜索框输入的字符串是不是纯数字
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
