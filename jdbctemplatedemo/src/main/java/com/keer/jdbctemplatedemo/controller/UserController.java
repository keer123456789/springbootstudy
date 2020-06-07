package com.keer.jdbctemplatedemo.controller;

import com.keer.jdbctemplatedemo.pojo.User;
import com.keer.jdbctemplatedemo.pojo.WebResult;
import com.keer.jdbctemplatedemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jdbctemplatedemo.Controller
 * @Author: keer
 * @CreateTime: 2020-03-04 10:07
 * @Description:
 */
@RestController
@Api(tags = "user api")
public class UserController {
    protected Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "增加用户")
    public WebResult addUser(@RequestBody User user) {
        logger.info("接收到增加用户的请求，请求信息：" + user.toString());
        return userService.insertUser(user);
    }

    /**
     * 删除用户
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/removeUser/{userName}", method = RequestMethod.GET)
    @ApiOperation("根据用户姓名删除信息")
    public WebResult removeUser(@PathVariable String userName) {
        logger.info("接收到增加用户的请求，请求信息：" + userName);
        return userService.removeUser(userName);
    }

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUserPassword",method=RequestMethod.POST)
    @ApiOperation("修改用户名密码")
    public WebResult updateUserPassword(@RequestBody User user){
        logger.info("接收到更改用户密码的请求，请求信息："+user.toString());
        return userService.updateUserPassword(user);
    }

    @RequestMapping(value = "/selectUserInfo",method=RequestMethod.GET)
    @ApiOperation("查询全部用户信息")
    public WebResult selectUserInfo(){
        logger.info("接收到查询全部用户信息请求");
        return userService.selectUserInfo();
    }
}
