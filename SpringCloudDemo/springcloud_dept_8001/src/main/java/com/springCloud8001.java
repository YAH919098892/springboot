package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//注册到eureka中
@EnableDiscoveryClient//服务发现
public class springCloud8001 {
    public static void main(String[] args) {
        SpringApplication.run(springCloud8001.class,args);
    }
}
