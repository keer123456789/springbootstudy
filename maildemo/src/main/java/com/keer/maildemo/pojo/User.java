package com.keer.maildemo.pojo;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.maildemo.pojo
 * @Author: keer
 * @CreateTime: 2020-03-07 14:38
 * @Description:
 */
public class User {
    private String name;
    private String num;
    private String department;

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
