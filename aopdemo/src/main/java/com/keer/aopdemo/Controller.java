package com.keer.aopdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.aopdemo
 * @Author: keer
 * @CreateTime: 2020-03-20 09:19
 * @Description:
 */
@RestController
public class Controller {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/get1/{name}")
    public String get1(@PathVariable String name) {
        logger.info("接收到请求：/get1, 数据参数：" + name);
        return name + "，welcome to AOP";
    }

    @GetMapping("/get2/{name}")
    public String get2(@PathVariable String name) {
        logger.info("接收到请求：/get2， 数据参数：" + name);
        return name + "，welcome to AOP";
    }
}
