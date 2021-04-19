package com.service;

import com.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "SPRINGCLOUD-DEVT")//提供服务的服务名称
public interface UserService {
    @RequestMapping("/getOne/{id}")//与提供服务的地址一样
    public User selUserById(@PathVariable int id);
}