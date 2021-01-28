package com.imooc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {
    @Value("${server.port}")
    private int port;
    @Value("${name}")
    private String name;
    @GetMapping("/client/init")
    public String getPort()
    {
        return "当前服务端口:"+port+",当前名称:"+name;
    }
}
