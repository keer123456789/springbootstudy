package com.keer.redistemplatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedistemplatedemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(RedistemplatedemoApplication.class, args);

    }

}
