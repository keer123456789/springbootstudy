package com.keer.mybatisdemo.controller;

import com.keer.mybatisdemo.pojo.User;
import com.keer.mybatisdemo.pojo.WebResult;
import com.keer.mybatisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.controller
 * @Author: keer
 * @CreateTime: 2020-03-08 17:30
 * @Description:
 */
@RestController
public class UserController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping("/getAllUserInfo")
    public WebResult getAllUser() {
        logger.info("接收到请求：GET /getAllUserInfo");
        return userService.getAllUserInfo();
    }

    @PostMapping("/addUserInfo")
    public WebResult addUserInfo(@RequestBody User user) {
        logger.info("接收到请求，/addUserInfo, date:" + user);
        return userService.addUserInfo(user);
    }

    @GetMapping("/getUserInfoByID/{id}")
    public WebResult getUserInfoByID(@PathVariable String id) {
        logger.info("接收到请求，/getUserInfoByID/{id}, date:" + id);
        return userService.getUserInfoByID(id);
    }

    @PostMapping("/updateUserNameByID")
    public WebResult updateUserNameByID(@RequestBody User user) {
        logger.info("接收到请求，/updateUserNameByID, date:" + user);
        return userService.updateUserNameByID(user);
    }

    @GetMapping("/deleteUserInfoByID/{id}")
    public WebResult deleteUserInfoByID(@PathVariable String id) {
        logger.info("接收到请求，/deleteUserInfoByID/{id}, date:" + id);
        return userService.deleteUserInfoByID(id);
    }
}
