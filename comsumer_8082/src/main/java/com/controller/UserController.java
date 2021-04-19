package com.controller;


import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    //通过接口的方式去获取服务
public UserService userService=null;
//通过接口的方式去获取服务
    @RequestMapping("/getUserById111/{id}")
    public User getAllUser(@PathVariable int id){
        return userService.selUserById(id);
    }
}
