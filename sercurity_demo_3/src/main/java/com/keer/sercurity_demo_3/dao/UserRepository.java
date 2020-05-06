package com.keer.sercurity_demo_3.dao;

import com.keer.sercurity_demo_3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.sercurity_demo_3.dao
 * @Author: keer
 * @CreateTime: 2020-04-30 15:52
 * @Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByName(String name);
}
