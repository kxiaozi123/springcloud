package com.imooc.fallback;

import com.imooc.client.ProductClient;
import com.imooc.entity.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ProductClientFallBack implements ProductClient {
    private static final Map<String, Object> map=new HashMap<>();
    static {
        map.put("status","false");
    }
    @Override
    public String showMsg() {
        return "当前服务已经被降级！！";
    }

    @Override
    public Map<String, Object> findAll() {
        map.put("msg","当前查询所有不可用，服务已经被降级！！");
        return map;
    }

    @Override
    public Map<String, Object> findOne(String productId) {
        map.put("msg","当前查询信息不可用，服务已经被降级！！");
        return map;
    }

    @Override
    public Map<String, Object> save(String name) {
        map.put("msg","当前保存商品信息不可用，服务已经被降级！！");
        return map;
    }

    @Override
    public Map<String, Object> update(Product product) {
        map.put("msg","当前更新商品信息不可用，服务已经被降级！！");
        return map;
    }
}
