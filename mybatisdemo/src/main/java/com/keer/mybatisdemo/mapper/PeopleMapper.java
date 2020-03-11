package com.keer.mybatisdemo.mapper;

import com.keer.mybatisdemo.pojo.People;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.mapper
 * @Author: keer
 * @CreateTime: 2020-03-08 20:16
 * @Description:
 */
public interface PeopleMapper {
    /**
     * 查询全部个人信息
     * @return
     */
    @Select("select * from people")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age"),
            @Result(property = "address",column = "address")
    })
    List<People> getAllPeopleInfo();

    /**
     * 根据id查询个人信息
     * @param id
     * @return
     */
    @Select("select * from people where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property="name",column = "name"),
            @Result(property = "address",column = "address"),
            @Result(property = "age",column = "age")
    })
    People getPeopleInfoByID(int id);

    /**
     * 增加人员信息
     * @param people
     * @return
     */
    @Insert("insert into people(id,name,address,age)values(#{id},#{name},#{address},#{age})")
    int addPeopleInfo(People people);

    /**
     * 根据ID更改人员姓名
     * @param name
     * @param id
     * @return
     */
    @Update("update people set name=#{name} where id = #{id}")
    int updatePeopleNameByID(String name,int id);

    /**
     * 根据ID删除人员信息
     * @param id
     * @return
     */
    @Delete("delete from people where id= #{id}")
    int deletePeopleInfoByID(int id);
}
