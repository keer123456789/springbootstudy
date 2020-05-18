package com.keer.befor_run_demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.befor_run_demo.config
 * @Author: keer
 * @CreateTime: 2020-05-12 16:21
 * @Description:
 */
@Configuration
public class MyConfig_3 implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("===================Service 3====================");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
