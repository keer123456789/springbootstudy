package com.keer.mybatisdemo.service.implement;

import com.keer.mybatisdemo.mapper.UserMapper;
import com.keer.mybatisdemo.pojo.User;
import com.keer.mybatisdemo.pojo.WebResult;
import com.keer.mybatisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.service.implement
 * @Author: keer
 * @CreateTime: 2020-03-08 17:31
 * @Description: 用户接口实现
 */
@Service
public class UserSeviceImpl implements UserService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserMapper userMapper;

    /**
     * 获取全部用户数据
     *
     * @return
     */
    @Override
    public WebResult getAllUserInfo() {
        List<User> users = userMapper.getAll();
        WebResult webResult = new WebResult();
        webResult.setData(users);
        webResult.setStatus(WebResult.SUCCESS);
        webResult.setMessage("select user info success");
        logger.info("select user info success,data:" + users.toString());
        return webResult;
    }

    @Override
    public WebResult addUserInfo(User user) {
        WebResult webResult = new WebResult();
        if (userMapper.addUserInfo(user) == 1) {
            webResult.setData(1);
            webResult.setMessage("add user info success");
            webResult.setStatus(WebResult.SUCCESS);
            logger.info("add user info success, data :" + 1);
        } else {
            webResult.setStatus(WebResult.ERROR);
            webResult.setMessage("add user info fail");
            webResult.setData(0);
            logger.error("add user info fail");
        }
        return webResult;
    }

    @Override
    public WebResult getUserInfoByID(String id) {
        WebResult webResult = new WebResult();
        User user = userMapper.getUserInfoByID(id);
        if (user.equals(null)) {
            webResult.setMessage("select user info by id fail");
            webResult.setStatus(WebResult.ERROR);
            logger.error("select user info by id fail");
        } else {
            webResult.setStatus(WebResult.SUCCESS);
            webResult.setMessage("select user info by id success");
            webResult.setData(user);
            logger.info("select user info by id success,data :" + user.toString());
        }
        return webResult;
    }

    @Override
    public WebResult updateUserNameByID(User user) {
        WebResult webResult = new WebResult();
        if (userMapper.updateUserNameByID(user.getName(), user.getId()) == 1) {
            webResult.setData(1);
            webResult.setMessage("update user info success");
            webResult.setStatus(WebResult.SUCCESS);
            logger.info("update user info success");
        } else {
            webResult.setStatus(WebResult.ERROR);
            webResult.setMessage("update user info fail");
            webResult.setData(0);
            logger.error("update user info fail");
        }
        return webResult;
    }

    @Override
    public WebResult deleteUserInfoByID(String id) {
        WebResult webResult = new WebResult();
        if (userMapper.deleteUserInfoByID(id) == 1) {
            webResult.setData(1);
            webResult.setMessage("delete user info success");
            webResult.setStatus(WebResult.SUCCESS);
            logger.info("delete user info success");
        } else {
            webResult.setData(0);
            webResult.setMessage("delete user info fail");
            webResult.setStatus(WebResult.ERROR);
            logger.error("delete user info fail");
        }
        return webResult;
    }
}
