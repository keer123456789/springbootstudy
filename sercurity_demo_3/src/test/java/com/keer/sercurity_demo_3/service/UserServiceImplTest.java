package com.keer.sercurity_demo_3.service;

import com.keer.sercurity_demo_3.SercurityDemo3ApplicationTests;
import com.keer.sercurity_demo_3.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.sercurity_demo_3.service
 * @Author: keer
 * @CreateTime: 2020-05-04 08:23
 * @Description:
 */

@Component
public class UserServiceImplTest extends SercurityDemo3ApplicationTests {
    @Autowired
    UserService userService;


    @Test
    public void create() {
        User user1 = new User();
        user1.setPassword("123456");
        user1.setName("keer");
        User user2 = new User();
        user2.setName("可耳");
        user2.setPassword("654321");
        userService.createUser(user1);
        userService.createUser(user2);
    }
}
