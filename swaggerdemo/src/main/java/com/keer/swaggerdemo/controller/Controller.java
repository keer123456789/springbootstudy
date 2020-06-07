package com.keer.swaggerdemo.controller;

import com.keer.swaggerdemo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.swaggerdemo.controller
 * @Author: keer
 * @CreateTime: 2020-06-07 16:14
 * @Description:
 */
@RestController
@Api(tags = "swagger demo API info")
public class Controller {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/postTest")
    @ApiOperation(value = "post method,data is json", notes = "输入用户信息")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    public String postMethod(@RequestBody User user) {
        logger.info("接收到post请求：" + user.toString());
        return "传来数据： " + user.toString();
    }

    @GetMapping("/getTest")
    @ApiOperation(value = "get method")
    public String getMethod() {
        logger.info("接收到get请求");
        return "Swagger demo test for keer";
    }


}
