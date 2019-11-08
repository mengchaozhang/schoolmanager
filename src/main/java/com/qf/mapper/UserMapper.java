package com.qf.mapper;

import com.qf.pojo.User;

import java.util.List;

public interface UserMapper {

    public User getUser(User user);

    public List<User> getTeacherList();
}
