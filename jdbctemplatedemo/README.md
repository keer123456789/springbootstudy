# SpringBoot 使用JdbcTemplate 

## 1 介绍
Springboot 使用JdbcTemplate来对mysql进行增删改查。   
具体说明参见CSDN博客：[https://blog.csdn.net/weixin_41938180/article/details/104656117](https://blog.csdn.net/weixin_41938180/article/details/104656117)

## 2 使用说明
1. 将`mydb.sql`文件在mysql数据库运行
2. 启动springboot项目
3. `rest-api.http`文件是idea中http-client插件的文件，如果不是该IDE，可按照下面接口自行ceshi
```

#获得全部用户信息
GET http://127.0.0.1:8080/selectUserInfo
Accept: application/json

###

#增加用户信息
POST http://127.0.0.1:8080/addUser
Content-Type: application/json

{
  "name":"keer",
  "password":"12345678"
}

###

#更改用户密码
POST http://127.0.0.1:8080/updateUserPassword
Content-Type: application/json

{
	"name":"keer",
	"password":"keer"
}

###
#删除用户
GET http://127.0.0.1:8080/removeUser/keer
Accept: application/json

###
```



