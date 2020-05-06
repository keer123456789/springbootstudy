package com.keer.sercurity_demo_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SercurityDemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(SercurityDemo3Application.class, args);
    }

}
