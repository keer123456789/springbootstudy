package com.keer.befor_run_demo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.befor_run_demo.config
 * @Author: keer
 * @CreateTime: 2020-05-12 16:20
 * @Description:
 */
//@Configuration
public class MyConfig_2 implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("===================Service 2====================");
    }
}
