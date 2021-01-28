package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Ribbon是基于客户端的负载均衡
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/user/showProductMsg")
    public String showProductMsg()
    {
        RestTemplate restTemplate=new RestTemplate();
        //无法进行负载均衡
        //做不到高效剔除
        String msg = restTemplate.getForObject("http://localhost:9998/product/showMsg", String.class);
        log.info("拿到的回调信息:{}",msg);
        return msg;

    }
    @GetMapping("/user/findAllProduct")
    public String findAllProduct()
    {
        log.info("进入用户服务...");
//        ServiceInstance serviceInstance = loadBalancerClient.choose("products");
//        System.out.println(serviceInstance.getHost());
//        System.out.println(serviceInstance.getPort());
//        System.out.println(serviceInstance.getUri());
//        RestTemplate restTemplate=new RestTemplate();
//        String msg = restTemplate.
//                getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/findAll",
//                        String.class);
        //有客户端缓存的存在
        String msg = restTemplate.getForObject("http://products/product/findAll", String.class);
        log.info("拿到products的回调信息:{}",msg);
        /*List<ServiceInstance> serviceInstances = discoveryClient.getInstances("product");
        for (ServiceInstance serviceInstance : serviceInstances) {
            System.out.println(serviceInstance.getHost());
            System.out.println(serviceInstance.getPort());
        }*/
        return msg;

    }
}
