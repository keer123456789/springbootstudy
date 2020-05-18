package com.keer.befor_run_demo.config;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.befor_run_demo.config
 * @Author: keer
 * @CreateTime: 2020-05-12 16:14
 * @Description:
 */
@Configuration
public class MyConfig_1 {
    @PostConstruct
    public void test() {
        System.out.println("===================Service 1====================");
    }
}
