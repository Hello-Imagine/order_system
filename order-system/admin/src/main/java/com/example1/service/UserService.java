package com.example1.service;

import com.example1.entity.User;
import com.example1.entity.UserSales;

import java.util.List;

public interface UserService {
    //增加员工
    public boolean insert(User user);

    //删除员工
    public boolean deleteById(Integer id);

    //更新员工信息
    public boolean update(User user);

    //根据ID查询员工
    public User selectById(Integer id);

    //显示所有员工信息
    public List<User> listAll();

    //根据员工姓名进行模糊查询
    public List<User> fuzzySearchByName(String part);

    //根据员工身份筛选员工
    public List<User> listByRole(Integer role);

    //查找销量前三的服务员
    public List<UserSales> selectTop3Waiter();
}
