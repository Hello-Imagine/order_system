package com.example1.controller;

import com.example1.entity.User;
import com.example1.service.UserService;
import com.example1.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/delete")
    public JsonResponse delete(Integer id){
        System.out.println(id);
        // 如果成功删除
        if(userService.deleteById(id))
            return JsonResponse.success(null);
        // 如果删除失败，返回相关信息
        else return JsonResponse.failure("failed to delete. No such a person of the id.");
    }

    @RequestMapping("/add")
    public JsonResponse add(User user){
        System.out.println(user.getBonus());
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());

        if(userService.insert(user))
            return JsonResponse.success(null);
        else return JsonResponse.failure("failed to insert. Check the field of user.");
    }

    @RequestMapping("/edit")
    public JsonResponse edit(User user){
        if(userService.update(user))
            return JsonResponse.success(null);
        else return JsonResponse.failure("failed to edit the user. Check the field of user.");
    }

    @RequestMapping("/list")
    public JsonResponse list(){
        return JsonResponse.success(userService.listAll());
    }

    @RequestMapping("/select_by_id")
    public JsonResponse selectById(Integer id){
        User user = userService.selectById(id);
        if (user!=null)
            return JsonResponse.success(user);
        else return JsonResponse.failure("No users searched");
    }

    @RequestMapping("/select_by_name")
    public JsonResponse selectByName(String username){
        return JsonResponse.success(userService.fuzzySearchByName(username));
    }

    @RequestMapping("/select_by_role")
    public JsonResponse selectByRole(Integer role){
        return JsonResponse.success(userService.listByRole(role));
    }

    @RequestMapping("/select_by_name_id")
    public JsonResponse selectByNameOrId(String str){
        // 如果能转换为数字，在 id 中查找
        try {
            Integer id = Integer.parseInt(str);
            return JsonResponse.success(userService.selectById(id));
        }
        // 如果输入不能转换为 id，只在姓名中查找
        catch (Exception e){
            return JsonResponse.success(userService.fuzzySearchByName(str));
        }
    }
}
