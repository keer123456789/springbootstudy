package com.keer.security_demo_1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.security_demo_1.controller
 * @Author: keer
 * @CreateTime: 2020-04-07 19:40
 * @Description:
 */
@RestController
@RequestMapping("/security")
public class Controller {
    protected Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello() {
        return "hello_world";
    }
}
