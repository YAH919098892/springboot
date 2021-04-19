package com;

import myrule.MyIEule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-DEVT",configuration = MyIEule.class)//自定义算法
public class Springbootdemo8081Application {
    public static void main(String[] args) {
        SpringApplication.run(Springbootdemo8081Application.class, args);
    }

}
