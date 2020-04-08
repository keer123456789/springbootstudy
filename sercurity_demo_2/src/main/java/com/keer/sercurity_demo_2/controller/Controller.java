package com.keer.sercurity_demo_2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.sercurity_demo_2.controller
 * @Author: keer
 * @CreateTime: 2020-04-08 15:53
 * @Description:
 */
@RestController
@RequestMapping("/security")
public class Controller {
    protected Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "hello_world";
    }

    /**
     * 拥有ADMIN权限的用户才能访问
     * @return
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String helloAdmin() {
        return "hello, admin";
    }

    /**
     * 拥有ADMIN或USER权限的用户才能访问
     * @return
     */
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String helloUser() {
        return "hello, user";
    }
}