package com.keer.scheduleddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author keer
 * schedule注解使用例子
 */
@SpringBootApplication
@EnableScheduling
public class ScheduleddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleddemoApplication.class, args);
    }

}
