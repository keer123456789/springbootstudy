package com.keer.jpa_demo.dao;

import com.keer.jpa_demo.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jpa_demo.dao
 * @Author: keer
 * @CreateTime: 2020-04-22 15:23
 * @Description:
 */
@Component
public interface UserDao extends CrudRepository<User, Integer> {
    /**
     * 修改用户姓名根据id
     *
     * @param name
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update user u set u.name=:name where u.id=:id ")
    @Transactional
    int updateUserById(@Param("name") String name, @Param("id") int id);
}
