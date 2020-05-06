package com.keer.redisdemo.pojo;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.pojo
 * @Author: keer
 * @CreateTime: 2020-05-06 09:06
 * @Description:
 */
@Entity(name = "user")
public class User  {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "address", nullable = false)
    private String address;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public User() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
