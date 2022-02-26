package com.example1.service.impl;

import com.example1.entity.User;
import com.example1.mapper.UserMapper;
import com.example1.service.UserService;
import com.example1.entity.UserSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public boolean insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public List<User> fuzzySearchByName(String part) {
        return userMapper.fuzzySearchByName(part);
    }

    @Override
    public List<User> listByRole(Integer role) {
        return userMapper.listByRole(role);
    }

    @Override
    public List<UserSales> selectTop3Waiter() {
        return userMapper.selectTop3Waiter();
    }
}
