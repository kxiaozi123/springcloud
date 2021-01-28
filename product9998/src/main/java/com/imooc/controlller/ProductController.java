package com.imooc.controlller;

import com.imooc.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
/**
 * 服务熔断在服务端 每个方法都需要加
 *  @HystrixCommand(defaultFallback = "testBreakFallBack")
 */
public class ProductController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/product/showMsg")
    public String showMsg() {
        log.info("调用商品服务-----");
        return "调用商品服务-----,当前服务的端口:" + port;
    }

    @GetMapping("/product/findAll")
    public Map<String, Object> findAll() {
        Map<String, Object> map = new HashMap<>();
        log.info("进入商品服务，查询所有商品信息");
        map.put("status", true);
        map.put("msg", "查询所有商品信息成功，当前端口:" + port);
        return map;
    }

    @GetMapping("/product/findOne")
    public Map<String, Object> findOne(@RequestParam("productId") String productId) {
        Map<String, Object> map = new HashMap<>();
        log.info("商品服务，接受到的商品id为:{}", productId);
        map.put("status", true);
        map.put("msg", "根据商品id查询商品信息成功！当前服务的端口号:" + port);
        map.put("productId", productId);
        return map;
    }

    @PostMapping("/product/save")
    public Map<String, Object> save(@RequestParam("name") String name) {
        Map<String, Object> map = new HashMap<>();
        log.info("商品服务，接受到的商品name为:{}", name);
        map.put("status", true);
        map.put("msg", "根据商品id查询商品信息成功！当前服务的端口号:" + port);
        map.put("name", name);
        return map;
    }

    @PostMapping("/product/update")
    public Map<String, Object> save(@RequestBody Product product) {
        Map<String, Object> map = new HashMap<>();
       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        log.info("商品服务，接受到的商品product为:{}", product);
        map.put("status", true);
        map.put("msg", "根据商品id查询商品信息成功！当前服务的端口号:" + port);
        map.put("product", product);
        return map;
    }


    @GetMapping("/product/break")
    //@HystrixCommand(fallbackMethod = "testBreakFallBack")
    @HystrixCommand(defaultFallback = "testBreakFallBack")
    public String testBreak(Integer id) {
        if(id<0)
        {
            throw new RuntimeException("非法参数，id不能小于0");
        }
        return "访问成功，当前查询的id为"+id;

    }
    public String testBreakFallBack()
    {
        //return "当前传入的id:"+id+",不是有效参数，触发熔断！";
        return "服务不可用，触发熔断！";
    }
}
