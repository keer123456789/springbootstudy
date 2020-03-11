package com.keer.mybatisdemo.controller;

import com.google.gson.Gson;
import com.keer.mybatisdemo.pojo.User;
import com.keer.mybatisdemo.pojo.WebResult;
import com.keer.mybatisdemo.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.controller
 * @Author: keer
 * @CreateTime: 2020-03-11 20:58
 * @Description:
 */
@RunWith(SpringRunner.class)
@DisplayName("用户API接口测试")
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @SpringBootApplication(scanBasePackages = {"com.keer.mybatisdemo.controller"})
    static class InnerConfig {
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService UserService;

    @Before
    public void setup() {
        WebResult webResult = new WebResult();
        webResult.setStatus(WebResult.SUCCESS);

        Mockito.when(UserService.getAllUserInfo()).thenReturn(webResult);
        Mockito.when(UserService.addUserInfo(Mockito.any())).thenReturn(webResult);
        Mockito.when(UserService.getUserInfoByID(Mockito.anyString())).thenReturn(webResult);
        Mockito.when(UserService.updateUserNameByID(Mockito.any())).thenReturn(webResult);
        Mockito.when(UserService.deleteUserInfoByID(Mockito.anyString())).thenReturn(webResult);
    }

    @Test
    @DisplayName(value = "测试获取全部用户信息接口")
    public void testGetAllUserInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getAllUserInfo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("0")));
    }

    @Test
    @DisplayName(value = "增加用户信息接口")
    public void testAddUserInfo() throws Exception {
        Gson gson = new Gson();
        User user = new User("java", "太监", "1");
        String json = gson.toJson(user);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/addUserInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("0")));
    }

    @Test
    @DisplayName(value = "根据用户ID查询用户信息接口")
    public void testGetUserInfoByID() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getUserInfoByID/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("0")));
    }

    @Test
    @DisplayName(value = "根据用户ID更新用户姓名接口")
    public void testUpdateUserNameByID() throws Exception {
        Gson gson = new Gson();
        User user = new User("java", "太监", "1");
        String json = gson.toJson(user);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/updateUserNameByID")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("0")));

    }

    @Test
    @DisplayName(value = "根据用户ID删除用户信息接口")
    public void testDeleteUserInfoByID() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/deleteUserInfoByID/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("0")));

    }

}
