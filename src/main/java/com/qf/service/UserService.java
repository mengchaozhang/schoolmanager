package com.qf.service;

import com.qf.pojo.User;

import java.util.List;

public interface UserService {

    public User userLogin(User user);

    public List<User> getTeacherList();

}
