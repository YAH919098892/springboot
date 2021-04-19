package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("/getAllUser")
    public List<User> getAllUser(HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setCharacterEncoding("utf-8");
        List<User> users = userService.selAllUser();
        return users;
    }
    @RequestMapping("/getOne/{id}")
    public User getUser(HttpServletResponse response,  @PathVariable("id") int id){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setCharacterEncoding("utf-8");
        User user = userService.selUserById(id);
        return user;
    }
//    @RequestMapping("/getAllUser2")
//    public List<User> getAllUser2(){
//        return (List<User>) restTemplate.getForObject("http://localhost:8081/getAllUser",User.class);
//    }
//    @RequestMapping("/getOne82/{id}")
//    public User getUser(HttpServletResponse response, @PathVariable("id") int id){
//        User forObject = restTemplate.getForObject("http://localhost:8081/getOne/"+id, User.class);
//        return forObject;
//    }
}
