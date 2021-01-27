package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//启动服务的注册与发现功能
@EnableDiscoveryClient
public class Users9999Application {

    public static void main(String[] args) {
        SpringApplication.run(Users9999Application.class, args);
    }

}
