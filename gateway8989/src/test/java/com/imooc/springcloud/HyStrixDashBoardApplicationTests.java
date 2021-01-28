package com.imooc.springcloud;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HyStrixDashBoardApplicationTests {

    @Test
    public void contextLoads() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

}
