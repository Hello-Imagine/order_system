package com.example1.controller;

import com.example1.entity.User;
import com.example1.service.UserService;
import com.example1.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //员工登录
    @RequestMapping("/index")
    public JsonResponse login(Integer user_id, String password){
        User user = userService.selectById(user_id);

        if (user == null)
            return JsonResponse.failure("1");
        else  if(!Objects.equals(user.getPassword(), password))
            return JsonResponse.failure("2");
        else return JsonResponse.success(user);
    }

    //删除员工
    @PostMapping("/delete")
    public JsonResponse delete(Integer id){
        // 如果成功删除
        if(userService.deleteById(id))
            return JsonResponse.success(null);
        // 如果删除失败，返回相关信息
        else return JsonResponse.failure("failed to delete. No such a person of the id.");
    }

    //增加员工
    @RequestMapping("/add")
    public JsonResponse add(User user){
        if(userService.insert(user))
            return JsonResponse.success(user);
        else return JsonResponse.failure("failed to insert. Check the field of user.");
    }

    //更新员工信息
    @RequestMapping("/edit")
    public JsonResponse edit(User user){
        if(userService.update(user))
            return JsonResponse.success(null);
        else return JsonResponse.failure("failed to edit the user. Check the field of user.");
    }

    //显示所有员工信息
    @RequestMapping("/list")
    public JsonResponse list(){
        return JsonResponse.success(userService.listAll());
    }

    //根据ID查询员工
    @RequestMapping("/select_by_id")
    public JsonResponse selectById(Integer id){
        User user = userService.selectById(id);
        if (user!=null)
            return JsonResponse.success(user);
        else return JsonResponse.failure("No users searched");
    }

    //根据员工姓名进行模糊查询
    @RequestMapping("/select_by_name")
    public JsonResponse selectByName(String username){
        return JsonResponse.success(userService.fuzzySearchByName(username));
    }

    //根据员工身份筛选员工
    @RequestMapping("/select_by_role")
    public JsonResponse selectByRole(Integer role){
        return JsonResponse.success(userService.listByRole(role));
    }

    //根据员工姓名或者ID进行模糊查询
    @RequestMapping("/select_by_name_id")
    public JsonResponse selectByNameOrId(String query){
        //如果输入查询条件为空，返回所有值
        if (query == null)
            return JsonResponse.success(userService.listAll());

        // 如果能转换为数字，在 id 中查找
        try {
            Integer id = Integer.parseInt(query);
            return JsonResponse.success(userService.selectById(id));
        }
        // 如果输入不能转换为 id，只在姓名中查找
        catch (Exception e){
            return JsonResponse.success(userService.fuzzySearchByName(query));
        }
    }

    //显示员工基本信息
    @RequestMapping("/user_info")
    public JsonResponse adminInfo(Integer id){
        User user = userService.selectById(id);

        if (user == null)
            return JsonResponse.failure("The user does not exist");
//        if (user.getRole()!=1)
//            return JsonResponse.failure("The user is not an admin");
        else
            return JsonResponse.success(user);
    }

    //查找销量前三的服务员
    @RequestMapping("/get_top3_waiter")
    public JsonResponse getTop3Waiter(){
        return JsonResponse.success(userService.selectTop3Waiter());
    }

}
