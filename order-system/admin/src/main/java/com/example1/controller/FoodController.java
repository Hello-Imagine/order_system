package com.example1.controller;

import com.example1.entity.Food;
import com.example1.service.FoodService;
import com.example1.service.ImageService2;
import com.example1.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;
    @Autowired
    private ImageService2 imageService2;

    //添加菜品
    @RequestMapping("/add")
    public JsonResponse addFood(Food food, MultipartFile file) throws IOException {
//        System.out.println(food);
//        return JsonResponse.success(null);

        if(food.getImage() == null){
            String image = imageService2.uploadImage(file);
            food.setImage(image);
        }

        if(foodService.add(food))
            return JsonResponse.success(food);
        else
            return JsonResponse.failure("failed to insert. Check the field of food.");
    }

    //删除菜品
    @RequestMapping("/delete")
    public JsonResponse delete(Integer id){
        if(foodService.deleteById(id))
            return JsonResponse.success(null);
        else return JsonResponse.failure("No such a food to be delete.");
    }

    //修改菜品
    @RequestMapping("/edit")
    public JsonResponse editFood(Food food){
        if(foodService.update(food))
            return JsonResponse.success(null);
        return JsonResponse.failure("failed to update. Check the field of food.");
    }

    //设置菜品可售
    @RequestMapping("/set_available")
    public JsonResponse setAvailable(Integer id){
        if (foodService.setAvailable(id))
            return JsonResponse.success(null);
        else return JsonResponse.failure("failed to set the food available.");
    }

    //设置菜品售空
    @RequestMapping("/set_not_available")
    public JsonResponse setNotAvailable(Integer id){
        if(foodService.setNotAvailable(id))
            return JsonResponse.success(null);
        else return JsonResponse.failure("failed to set the food not available.");
    }

    //显示所有菜品信息
    @RequestMapping("/list")
    public JsonResponse listAll(){
        List<Food> foodList = foodService.listAll();
        return JsonResponse.success(foodList);
    }

    //根据菜品ID查询
    @RequestMapping("/select_by_id")
    public JsonResponse selectById(Integer id){
        Food food = foodService.selectById(id);
        if (food!=null)
            return JsonResponse.success(food);
        else return JsonResponse.failure("No such a food");
    }

    //根据类别查询菜品
    @RequestMapping("/select_by_category")
    public JsonResponse listByCategory(Integer category){
        List<Food> foodList = foodService.listByCategory(category);
        return JsonResponse.success(foodList);
    }

    //根据价格区间查找菜品
    @RequestMapping("/select_by_price")
    public JsonResponse selectByPrice(Float min, Float max){
        List<Food> foodList = foodService.selectByPrice(min, max);
        return JsonResponse.success(foodList);
    }

    //根据菜品的编号或名称查找菜品
    @RequestMapping("/select_by_name_id")
    public JsonResponse selectByNameId(String query){
        //如果查询为空，则返回所有菜品数据
        if (query == null){
            return JsonResponse.success(foodService.listAll());
        }

        // 如果能转换为数字，在 id 中查找
        try {
            Integer id = Integer.parseInt(query);
            return JsonResponse.success(foodService.selectById(id));
        }
        // 如果输入不能转换为 id，只在菜品名称中查找
        catch( Exception e){
            return JsonResponse.success(foodService.fuzzySearchByName(query));
        }
    }

    //设置推荐菜品
    @RequestMapping("/set_like")
    public JsonResponse setLike(Integer id){
        if (foodService.setLike(id))
            return JsonResponse.success(null);
        else return JsonResponse.failure("No such a food.");
    }

    //取消推荐菜品
    @RequestMapping("/set_not_like")
    public JsonResponse setNotLike(Integer id){
        if (foodService.setNotLike(id))
            return JsonResponse.success(null);
        else return JsonResponse.failure("No such a food.");
    }

    //查询销售榜前三的菜品
    @RequestMapping("/get_top3_food")
    public JsonResponse selectTop3Food(){
        return JsonResponse.success(foodService.selectTop3Food());
    }
}
