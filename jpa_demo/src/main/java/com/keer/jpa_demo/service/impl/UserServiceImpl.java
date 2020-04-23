package com.keer.jpa_demo.service.impl;

import com.keer.jpa_demo.dao.UserDao;
import com.keer.jpa_demo.pojo.User;
import com.keer.jpa_demo.pojo.WebResult;
import com.keer.jpa_demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jpa_demo.service.impl
 * @Author: keer
 * @CreateTime: 2020-04-22 15:18
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDao userDao;


    /**
     * 增加单个用户信息
     *
     * @param user
     * @return
     */
    @Override
    public WebResult addUser(User user) {
        User res = userDao.save(user);
        WebResult result = new WebResult();
        if (res != null) {
            result.setData(user);
            result.setMessage("增加成功");
            result.setStatus(WebResult.SUCCESS);
            return result;
        }
        return null;
    }

    /**
     * 批量增加用户信息
     *
     * @param list
     * @return
     */
    @Override
    public WebResult addUsers(List list) {
        WebResult webResult = new WebResult();
        userDao.saveAll(list);
        List<User> failUsers = new ArrayList<>();
        for (Object o : list) {
            User user = (User) o;
            if (!userDao.existsById(user.getId())) {
                failUsers.add(user);
            }
        }
        if (failUsers.size() == 0) {
            webResult.setStatus(WebResult.SUCCESS);
            webResult.setMessage("插入成功");
        } else {
            webResult.setMessage("部分插入失败");
            webResult.setData(failUsers);
            webResult.setStatus(WebResult.ERROR);
        }
        return webResult;
    }

    /**
     * 删除用户信息
     *
     * @param user
     * @return
     */
    @Override
    public WebResult removeUser(User user) {
        userDao.delete(user);
        WebResult webResult = new WebResult();

        if (!userDao.existsById(user.getId())) {
            webResult.setStatus(WebResult.SUCCESS);
            webResult.setMessage("删除用户信息成功！");
        } else {
            webResult.setStatus(WebResult.ERROR);
            webResult.setMessage("删除用户信息失败！");
        }
        return webResult;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public WebResult updateUser(User user) {
        WebResult webResult = new WebResult();

        User oldUser = userDao.findById(user.getId());
        logger.info("查询信息：" + user.toString());
        if (oldUser != null) {
            User newUser = userDao.save(user);
            logger.info("更新信息：" + newUser.toString());
            webResult.setMessage("更新操作成功");
            webResult.setData(newUser);
            webResult.setStatus(WebResult.SUCCESS);
            return webResult;
        } else {
            User newUser = userDao.save(user);
            logger.info("插入信息信息：" + newUser.toString());
            webResult.setMessage("插入操作成功");
            webResult.setData(newUser);
            webResult.setStatus(WebResult.SUCCESS);
            return webResult;
        }
    }

    /**
     * 自定义更新：修改用户名
     *
     * @param name
     * @param id
     * @return
     */
    @Override
    public WebResult updateUserNameById(String name, int id) {
        int res = userDao.updateUserById(name, id);
        WebResult webResult = new WebResult();
        if (res == 1) {
            webResult.setStatus(WebResult.SUCCESS);
            webResult.setMessage("更新操作成功");
        } else {
            webResult.setStatus(WebResult.ERROR);
            webResult.setMessage("更新操作失败");
        }
        return webResult;
    }
}
