package com.keer.redisdemo.controller;

import com.keer.redisdemo.pojo.Student;
import com.keer.redisdemo.pojo.User;
import com.keer.redisdemo.service.StudentService;
import com.keer.redisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.controller
 * @Author: keer
 * @CreateTime: 2020-05-06 19:45
 * @Description:
 */
@RestController
@RequestMapping("/cache/student")
public class StudentController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String  addUser(@RequestBody Student student) {
        logger.info("接收到增加用户的请求，请求信息：" + student.toString());
        Student re=studentService.addNewStudent(student);
        if(re!=null){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/findStudentById/{id}",method = RequestMethod.GET)
    public Student selectUser(@PathVariable String id){
        logger.info("接收到查询用户的请求，请求信息：" +id);
        return studentService.findById(id);
    }
}
