package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//启动服务的注册与发现功能
//@EnableDiscoveryClient 可写可不写
//@EnableFeignClients
public class ConfigClient7879Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient7879Application.class, args);
    }

}
