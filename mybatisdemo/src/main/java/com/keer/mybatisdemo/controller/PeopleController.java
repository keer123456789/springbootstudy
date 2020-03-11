package com.keer.mybatisdemo.controller;

import com.keer.mybatisdemo.pojo.People;
import com.keer.mybatisdemo.pojo.WebResult;
import com.keer.mybatisdemo.service.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.controller
 * @Author: keer
 * @CreateTime: 2020-03-08 21:37
 * @Description:
 */
@RestController
public class PeopleController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PeopleService peopleService;

    @GetMapping("/getAllPeopleInfo")
    public WebResult getAllPeopleInfo() {
        logger.info("接收到请求：/getAllPeopleInfo");
        return peopleService.getAllPeopleInfo();
    }

    @PostMapping("/addPeopleInfo")
    public WebResult addPeopleInfo(@RequestBody People people) {
        logger.info("接收到请求：/getAllPeopleInfo");
        return peopleService.addPeopleInfo(people);
    }

    @GetMapping("/getPeopleInfoByID/{id}")
    public WebResult getPeopleInfoByID(@PathVariable int id) {
        logger.info("接收到请求：/getPeopleInfoByID/{id},data: " + id);
        return peopleService.getPeopleInfoByID(id);
    }

    @PostMapping("/updatePeopleNameByID")
    public WebResult updatePeopleNameByID(@RequestBody People people) {
        logger.info("接收到请求：/getPeopleInfoByID/{id},data: " + people.toString());
        return peopleService.updatePeopleNameByID(people.getName(), people.getId());
    }

    @GetMapping("/deletePeopleInfoByID/{id}")
    public WebResult deletePeopleInfoByID(@PathVariable int id) {
        logger.info("接收到请求：/deletePeopleInfoByID/{id},data: " + id);
        return peopleService.deletePeopleInfoByID(id);
    }
}
