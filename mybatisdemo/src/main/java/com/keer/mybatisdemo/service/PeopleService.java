package com.keer.mybatisdemo.service;

import com.keer.mybatisdemo.pojo.People;
import com.keer.mybatisdemo.pojo.WebResult;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.service
 * @Author: keer
 * @CreateTime: 2020-03-08 21:33
 * @Description: 人员接口
 */
public interface PeopleService {
    /**
     * 获取全部人员信息
     *
     * @return
     */
    WebResult getAllPeopleInfo();

    /**
     * 增加人员信息
     *
     * @param people
     * @return
     */
    WebResult addPeopleInfo(People people);

    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    WebResult getPeopleInfoByID(int id);

    /**
     * 根据人员id更改人员姓名
     *
     * @param name
     * @param id
     * @return
     */
    WebResult updatePeopleNameByID(String name, int id);

    /**
     * 根据用户id删除人员信息
     *
     * @param id
     * @return
     */
    WebResult deletePeopleInfoByID(int id);

}
