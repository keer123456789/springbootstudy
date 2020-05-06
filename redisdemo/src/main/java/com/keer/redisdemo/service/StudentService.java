package com.keer.redisdemo.service;

import com.keer.redisdemo.pojo.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.service
 * @Author: keer
 * @CreateTime: 2020-05-06 19:37
 * @Description:
 */
@CacheConfig(cacheNames = "c2")
public interface StudentService {
    /**
     * 增加新生
     * @param student
     * @return
     */
    @CachePut(key="#student.id")
    Student addNewStudent(Student student);

    /**
     * 根据学号查找学生信息
     * @param id
     * @return
     */
    @Cacheable
    Student findById(String id);
}
