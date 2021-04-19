package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Mapper
public interface UserMapper {
    public List<User> selAllUser();
    public User selUserById(int id);
    public int addUser(Map map);
    public int delUser(int id);
    public int updUser(int id);
}