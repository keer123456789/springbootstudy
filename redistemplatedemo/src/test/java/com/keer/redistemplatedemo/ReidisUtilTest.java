package com.keer.redistemplatedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redistemplatedemo
 * @Author: keer
 * @CreateTime: 2020-05-07 15:41
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReidisUtilTest {

    @Autowired
    RedisUtil util;

    @Test
    public void setUtil(){
        util.save("name","keer");
    }
}
