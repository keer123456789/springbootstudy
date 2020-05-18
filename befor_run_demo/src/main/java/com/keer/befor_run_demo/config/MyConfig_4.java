package com.keer.befor_run_demo.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;


import javax.annotation.PostConstruct;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.befor_run_demo.config
 * @Author: keer
 * @CreateTime: 2020-05-12 16:24
 * @Description:
 */
@Configuration
public class MyConfig_4 implements BeanPostProcessor {
    @PostConstruct
    public void  test(){
        System.out.println("===================Service 4====================");
    }
}
