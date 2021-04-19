package com.service;

import com.pojo.User;
import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> selAllUser();
    public User selUserById(int id);
    public int addUser(Map map);
    public int delUser(int id);
    public int updUser(int id);
}