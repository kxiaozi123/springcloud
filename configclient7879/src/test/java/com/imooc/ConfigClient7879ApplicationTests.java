package com.imooc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConfigClient7879ApplicationTests {

    @Test
    public void contextLoads() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

}
