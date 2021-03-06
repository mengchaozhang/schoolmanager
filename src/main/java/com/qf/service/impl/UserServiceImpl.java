package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User userLogin(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public List<User> getTeacherList() {
        return userMapper.getTeacherList();
    }
}
