package com.keer.sercurity_demo_3.controller;

import com.keer.sercurity_demo_3.entity.User;
import com.keer.sercurity_demo_3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.sercurity_demo_3.controller
 * @Author: keer
 * @CreateTime: 2020-05-03 22:10
 * @Description:
 */
@RestController
@RequestMapping("/security")
public class UserController {
    protected Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "hello_world";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        User res=userService.createUser(user);
        if(res==null){
            return "增加失败";
        }else {
            return "增加成功";
        }
    }

}
