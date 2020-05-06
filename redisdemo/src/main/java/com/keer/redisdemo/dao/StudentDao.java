package com.keer.redisdemo.dao;

import com.keer.redisdemo.pojo.Student;
import com.keer.redisdemo.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.dao
 * @Author: keer
 * @CreateTime: 2020-05-06 19:40
 * @Description:
 */
@Repository
public interface StudentDao extends CrudRepository<Student, String> {

}
