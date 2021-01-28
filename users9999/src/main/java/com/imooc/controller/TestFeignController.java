package com.imooc.controller;

import com.imooc.client.ProductClient;
import com.imooc.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class TestFeignController {
    @Autowired
    private ProductClient productClient;
    @GetMapping("/feign/test")
    public Map<String, Object> test()
    {
        log.info("进入测试feign调用的方法....");
        //String msg = productClient.showMsg();
        Map<String, Object> map = productClient.findAll();
        //log.info("调用商品服务返回的信息={}",msg);
        log.info("调用商品服务返回的信息={}",map);
        return map;
    }
    @GetMapping("/feign/findOne")
    public Map<String, Object> findOne(String productId){
        return productClient.findOne(productId);
    }
    @GetMapping("/feign/save")
    public Map<String, Object> save(String name){
        return productClient.save(name);
    }
    @GetMapping("/feign/update")
    public Map<String, Object> update(Product product){
        return productClient.update(product);
    }
}
