package com.keer.redisdemo.service.impl;

import com.keer.redisdemo.dao.StudentDao;
import com.keer.redisdemo.pojo.Student;
import com.keer.redisdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.service.impl
 * @Author: keer
 * @CreateTime: 2020-05-06 19:39
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public Student addNewStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student findById(String id) {
        return studentDao.findById(id).get();
    }
}
