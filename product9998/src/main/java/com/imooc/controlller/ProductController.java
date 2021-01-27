package com.imooc.controlller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ProductController {
    @Value("${server.port}")
    private int port;
    @GetMapping("/product/showMsg")
    public String showMsg()
    {
        log.info("调用商品服务-----");
        return "调用商品服务-----,当前服务的端口:"+port;
    }
    @GetMapping("/product/findAll")
    public Map<String,Object> findAll()
    {
        Map<String,Object> map=new HashMap<>();
        log.info("进入商品服务，查询所有商品信息");
        map.put("status",true);
        map.put("msg","查询所有商品信息成功，当前端口:"+port);
        return map;
    }
}
