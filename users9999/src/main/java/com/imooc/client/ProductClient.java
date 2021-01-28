package com.imooc.client;

import com.imooc.entity.Product;
import com.imooc.fallback.ProductClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "products",fallback = ProductClientFallBack.class)
public interface ProductClient {
    @GetMapping("/product/showMsg")
    String showMsg();


    @GetMapping("/product/findAll")
    Map<String, Object> findAll();

    @GetMapping("/product/findOne")
    Map<String, Object> findOne(@RequestParam("productId") String productId);

    @PostMapping("/product/save")
    Map<String, Object> save(@RequestParam("name") String name);

    @PostMapping("/product/update")
    Map<String, Object> update(@RequestBody Product product);

}
