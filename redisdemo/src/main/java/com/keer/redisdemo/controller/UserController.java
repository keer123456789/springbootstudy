package com.keer.redisdemo.controller;

import com.keer.redisdemo.pojo.User;
import com.keer.redisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.controller
 * @Author: keer
 * @CreateTime: 2020-05-06 09:30
 * @Description:
 */
@RestController
@RequestMapping("/cache/user/")
public class UserController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String  addUser(@RequestBody User user) {
        logger.info("接收到增加用户的请求，请求信息：" + user.toString());
        User re=userService.addNewUser(user);
        if(re!=null){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/findUserById/{id}",method = RequestMethod.GET)
    public User selectUser(@PathVariable int id){
        logger.info("接收到查询用户的请求，请求信息：" +id);
        return userService.findById(id);
    }
}
