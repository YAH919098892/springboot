package com.controller;


import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
public class UserController {
    private static final String REST_URL="http://SPRINGCLOUD-DEVT";
    private static final String REST_URL2="http://localhost:8001/getOne/";
    @Autowired
public RestTemplate restTemplate;
    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        return (List<User>) restTemplate.getForObject(REST_URL+"/getAllUser",User.class);
    }
//    @RequestMapping("/getone/{id}")
//    public User getAllUser2( @PathVariable int id){
//        return  restTemplate.getForObject(REST_URL2+id,User.class);
//    }
    @RequestMapping("/getOne/{id}")
    public User getOneUser( @PathVariable int id){
        return  restTemplate.getForObject(REST_URL+"/getOne/"+id,User.class);
    }
//    @RequestMapping("/getOne82/{id}")
//    public User getUser(@PathVariable("id") int id){
//        User forObject = restTemplate.getForObject(REST_URL+"/getOne/"+id, User.class);
//        return forObject;
//    }


}
