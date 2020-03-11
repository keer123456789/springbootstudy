package com.keer.mybatisdemo.service.implement;

import com.keer.mybatisdemo.mapper.PeopleMapper;
import com.keer.mybatisdemo.pojo.People;
import com.keer.mybatisdemo.pojo.WebResult;
import com.keer.mybatisdemo.service.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.service.implement
 * @Author: keer
 * @CreateTime: 2020-03-08 21:36
 * @Description:
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    PeopleMapper peopleMapper;


    @Override
    public WebResult getAllPeopleInfo() {
        WebResult webResult = new WebResult();
        List<People> list = peopleMapper.getAllPeopleInfo();
        webResult.setStatus(WebResult.SUCCESS);
        webResult.setMessage("select all people info success ");
        webResult.setData(list);
        logger.info("select all people info success ,data:" + list.toString());
        return webResult;
    }

    @Override
    public WebResult addPeopleInfo(People people) {
        WebResult webResult = new WebResult();
        if (peopleMapper.addPeopleInfo(people) == 1) {
            webResult.setData(1);
            webResult.setMessage("add people info success");
            webResult.setStatus(WebResult.SUCCESS);
            logger.info("add people info success");
        } else {
            webResult.setStatus(WebResult.ERROR);
            webResult.setMessage("add people info fail");
            webResult.setData(0);
            logger.error("add people info fail");
        }
        return webResult;
    }

    @Override
    public WebResult getPeopleInfoByID(int id) {
        WebResult webResult = new WebResult();
        People people = peopleMapper.getPeopleInfoByID(id);
        if (people == null) {
            webResult.setStatus(WebResult.ERROR);
            webResult.setMessage("select people info by id fail");
            logger.error("select people info by id fail");
        } else {
            webResult.setMessage("select people info by id success");
            webResult.setStatus(WebResult.SUCCESS);
            webResult.setData(people);
            logger.info("select people info by id success,date :" + people.toString());
        }
        return webResult;
    }

    @Override
    public WebResult updatePeopleNameByID(String name, int id) {
        WebResult webResult = new WebResult();
        if (peopleMapper.updatePeopleNameByID(name, id) == 1) {
            webResult.setData(1);
            webResult.setStatus(WebResult.SUCCESS);
            webResult.setMessage("update people name by id success");
            logger.info("update people name by id success");
        } else {
            webResult.setMessage("update people name by id fail");
            webResult.setStatus(WebResult.SUCCESS);
            logger.error("update people name by id fail");
        }
        return webResult;
    }

    @Override
    public WebResult deletePeopleInfoByID(int id) {
        WebResult webResult = new WebResult();
        if (peopleMapper.deletePeopleInfoByID(id) == 1) {
            webResult.setStatus(WebResult.SUCCESS);
            webResult.setMessage("delete people info by id success");
            webResult.setData(1);
            logger.info("delete people info by id success");
        } else {
            webResult.setStatus(WebResult.ERROR);
            webResult.setMessage("delete people info by id fail");
            webResult.setData(0);
            logger.error("delete people info by id fail");
        }
        return webResult;
    }
}
