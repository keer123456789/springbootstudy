package com.keer.jdbctemplatedemo.service.implement;

import com.keer.jdbctemplatedemo.dao.UserDao;
import com.keer.jdbctemplatedemo.pojo.User;
import com.keer.jdbctemplatedemo.pojo.WebResult;
import com.keer.jdbctemplatedemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jdbctemplatedemo.Service.Implement
 * @Author: keer
 * @CreateTime: 2020-03-04 10:22
 * @Description: 用户操作接口实现
 */
@Service
public class UserServiceImp implements UserService {
    protected Logger logger= LoggerFactory.getLogger(UserServiceImp.class);
    @Autowired
    UserDao userDao;

    /**
     * 增加用户信息
     * @param user
     * @return
     */
    @Override
    public WebResult insertUser(User user) {
        WebResult webResult = new WebResult();
        if (userDao.insertUser(user)) {
            webResult.setMessage("add user info success");
            webResult.setStatus(WebResult.SUCCESS);
            logger.info("add user info success");
        } else {
            webResult.setMessage("add user info fail");
            webResult.setStatus(WebResult.ERROR);
            logger.error("******add user info fail******");
        }
        return webResult;
    }

    /**
     * 删除用户
     * @param userName
     * @return
     */
    @Override
    public WebResult removeUser(String userName) {
        WebResult webResult=new WebResult();
        if(userDao.deleteUser(userName)){
            webResult.setMessage("delete user info success");
            webResult.setStatus(WebResult.SUCCESS);
            logger.info("delete user info success");
        } else {
            webResult.setMessage("delete user info fail");
            webResult.setStatus(WebResult.ERROR);
            logger.error("******delete user info fail******");
        }
        return webResult;
    }

    /**
     * 用户修改密码
     * @param user
     * @return
     */
    @Override
    public WebResult updateUserPassword(User user) {
        WebResult webResult=new WebResult();
        if(userDao.updateUserPassword(user)){
            webResult.setMessage("update user password info success");
            webResult.setStatus(WebResult.SUCCESS);
            logger.info("update user password info success");
        } else {
            webResult.setMessage("update user password info fail");
            webResult.setStatus(WebResult.ERROR);
            logger.error("******update user password info fail******");
        }
        return webResult;
    }

    /**
     * 查询全部用户信息
     * @return
     */
    @Override
    public WebResult selectUserInfo() {
        WebResult webResult=new WebResult();
        webResult.setData(userDao.selectUserInfo());
        webResult.setStatus(WebResult.SUCCESS);
        webResult.setMessage("select user info success");
        logger.info("select user info success");
        return webResult;
    }
}
