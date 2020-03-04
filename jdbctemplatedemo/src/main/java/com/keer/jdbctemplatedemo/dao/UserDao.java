package com.keer.jdbctemplatedemo.dao;

import com.keer.jdbctemplatedemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jdbctemplatedemo.dao
 * @Author: keer
 * @CreateTime: 2020-03-04 10:35
 * @Description: 数据库用户表操作
 */
@Component
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 在user表中插入新的用户信息
     *
     * @param user
     * @return
     */
    public boolean insertUser(User user) {
        int i = jdbcTemplate.update("insert into user(name,password) values(?,?)", user.getName(), user.getPassword());
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除user表中name= username 的记录
     *
     * @param userName
     * @return
     */
    public boolean deleteUser(String userName) {
        int i = jdbcTemplate.update("delete from user where name=?", userName);
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 更改对应用户的密码
     *
     * @param user
     * @return
     */
    public boolean updateUserPassword(User user) {
        int i = jdbcTemplate.update("update user set password=? where name=?", user.getPassword(), user.getName());
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查询用户表全部信息
     *
     * @return
     */
    public List selectUserInfo() {
        return jdbcTemplate.query("select * from user",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User u = new User();
                        u.setName(resultSet.getString("name"));
                        u.setPassWord(resultSet.getString("password"));
                        return u;
                    }
                });
    }
}
