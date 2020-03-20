package com.keer.jdbctemplatedemo.controller;

import com.google.gson.Gson;
import com.keer.jdbctemplatedemo.pojo.User;
import com.keer.jdbctemplatedemo.pojo.WebResult;
import com.keer.jdbctemplatedemo.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jdbctemplatedemo.controller
 * @Author: keer
 * @CreateTime: 2020-03-10 15:29
 * @Description: 用户API接口测试类
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@DisplayName("用户API接口测试")
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Before
    public void setup() {
        WebResult webResult = new WebResult();
        webResult.setStatus(WebResult.SUCCESS);
        Mockito.when(userService.selectUserInfo()).thenReturn(webResult);
        Mockito.when(userService.insertUser(Mockito.any())).thenReturn(webResult);
        Mockito.when(userService.updateUserPassword(Mockito.any())).thenReturn(webResult);
        Mockito.when(userService.removeUser(Mockito.anyString())).thenReturn(webResult);
    }

    @Test
    @DisplayName(value = "增加用户信息")
    public void testAddUser() throws Exception {
        Gson gson = new Gson();
        User user = new User("java", "spring");
        String json = gson.toJson(user);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("0")));
    }

    @Test
    @DisplayName("删除用户信息")
    public void testRemoveUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/removeUser/test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("0")));
    }

    @Test
    @DisplayName(value = "更改用户密码")
    public void testUpdateUserPassword() throws Exception {
        Gson gson = new Gson();
        User user = new User("java", "spring");
        String json = gson.toJson(user);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/updateUserPassword")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("0")));
    }

    @Test
    @DisplayName(value = "查询用户信息")
    public void testSelectUserInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/selectUserInfo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("0")));

    }


}
