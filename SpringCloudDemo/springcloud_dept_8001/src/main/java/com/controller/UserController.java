package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public DiscoveryClient discoveryClient;
    @RequestMapping("/getAllUser")
    public List<User> getAllUser(HttpServletResponse response, HttpServletRequest request){
        List<User> users = userService.selAllUser();
        return users;
    }
    @RequestMapping("/getOne/{id}")
    public User getUser(HttpServletResponse response,  @PathVariable("id") int id){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setCharacterEncoding("utf-8");
        User user = userService.selUserById(id);
        System.out.println(user);
        return user;
    }
    //    获取微服务的链表信息
    @RequestMapping("/getservice")
    public void getdiscorvery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-DEVT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getClass());
            System.out.println(instance.getHost());
            System.out.println(instance.getInstanceId());
            System.out.println(instance.getMetadata());
            System.out.println(instance.getPort());
            System.out.println(instance.getServiceId());
            System.out.println(instance.getUri());
        }
    }

}
