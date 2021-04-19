package com.serviceImp;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@Data
public class UserServiceImp implements UserService {
    @Autowired
    public UserMapper userMapper;
    public List<User> selAllUser() {
        return userMapper.selAllUser();
    }

    public User selUserById(int id) {
        return userMapper.selUserById(id);
    }


    public int addUser(Map map) {
        return userMapper.addUser(map);
    }

    public int delUser(int id) {
        return userMapper.delUser(id);
    }


    public int updUser(int id) {
        return userMapper.updUser(id);
    }
}