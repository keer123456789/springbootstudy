package com.keer.jpa_demo.controller;

import com.keer.jpa_demo.pojo.User;
import com.keer.jpa_demo.pojo.WebResult;
import com.keer.jpa_demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jpa_demo.controller
 * @Author: keer
 * @CreateTime: 2020-04-22 15:17
 * @Description:
 */
@RestController
@RequestMapping("/jpa")
public class UserController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public WebResult addUser(@RequestBody User user) {
        logger.info("接收到增加用户的请求，请求信息：" + user.toString());
        return userService.addUser(user);

    }

    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    public WebResult addUsers(@RequestBody List<User> users) {
        logger.info("接收到批量增加用户的请求，请求信息：" + users.toString());
        return userService.addUsers(users);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public WebResult updateUser(@RequestBody User user) {
        logger.info("接收到更改用户的请求，请求信息：" + user.toString());
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/updateUserNameById", method = RequestMethod.POST)
    public WebResult updateUserNameById(@RequestBody User user) {
        logger.info("接收到更改用户姓名的请求，请求信息：" + user.toString());
        return userService.updateUserNameById(user.getName(), user.getId());
    }


    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public WebResult addUsers(@RequestBody User user) {
        logger.info("接收到更改用户的请求，请求信息：" + user.toString());
        return userService.removeUser(user);
    }


}
