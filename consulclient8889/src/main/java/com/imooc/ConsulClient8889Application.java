package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class ConsulClient8889Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulClient8889Application.class, args);
    }

}
