# SpringBoot 使用jpa

## 1 介绍
Springboot 使用jpa来对mysql进行增删改查。   
具体说明参见CSDN博客：[https://blog.csdn.net/weixin_41938180/article/details/105817121](https://blog.csdn.net/weixin_41938180/article/details/105817121)

## 2 使用说明
1. 在mysql数据库中创建数据库 `jpademo`
2. 启动springboot项目
3. `rest-api.http`文件是idea中http-client插件的文件，如果不是该IDE，可按照下面接口自行ceshi
```


#增加用户信息
POST http://127.0.0.1:8080/jpa/addUser
Content-Type: application/json

{
  "id": 4,
  "name": "keer",
  "password": "133333",
  "address": "北京市平谷区"
}

###

#更改用户信息
POST http://127.0.0.1:8080/jpa/updateUser
Content-Type: application/json

{
  "id": 1,
  "name": "keer",
  "password": "133333",
  "address": "北京市平谷区"
}

###
#删除用户
POST http://127.0.0.1:8080/jpa/deleteUser
Content-Type: application/json

{
  "name": "java",
  "password": "hello world",
  "address": "main()",
  "id": 6
}

###
#批量增加用户
POST http://127.0.0.1:8080/jpa/addUsers
Content-Type: application/json

[
  {
    "name": "可耳",
    "password": "love",
    "address": "北京市"
  },
  {
    "name": "java",
    "password": "hello world",
    "address": "main()"
  }

]

###

#更改用户名
POST http://127.0.0.1:8080/jpa/updateUserNameById
Content-Type: application/json

{
  "id": 1,
  "name": "keer"
}

###

GET http://127.0.0.1:8080/jpa/selectAllUsers
Accept: application/json
###
```



