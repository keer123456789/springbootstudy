package com.keer.sercurity_demo_3.entity;

import javax.persistence.*;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.sercurity_demo_3.entity
 * @Author: keer
 * @CreateTime: 2020-04-30 15:44
 * @Description:
 */

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "password",nullable = false)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
