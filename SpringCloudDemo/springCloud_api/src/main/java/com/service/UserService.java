package com.service;

import com.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "SPRINGCLOUD-DEVT")//服务的名称
public interface UserService {
    public List<User> selAllUser();
    @GetMapping("/dept/get/{id}")
    public User selUserById(@PathVariable int id);
    public int addUser(Map map);
    public int delUser(int id);
    public int updUser(int id);
}