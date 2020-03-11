package com.keer.mybatisdemo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.controller
 * @Author: keer
 * @CreateTime: 2020-03-10 16:30
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@DisplayName("用户API接口测试")
@AutoConfigureMockMvc
public class PeopleControllerTest {
    @Autowired
    private MockMvc mvc;


}
