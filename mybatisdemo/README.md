# MyBatis 例子
## 1 介绍
主要对mybatis使用的两种方式进行使用。
Mybatis主要使用说明，请看CSDN博客：[https://blog.csdn.net/weixin_41938180/article/details/104747564](https://blog.csdn.net/weixin_41938180/article/details/104747564)
该项目进行了完整的单元测试，具体讲解参见CSDN博客：[]()
## 2. 使用说明
1. 将`mybatis.sql`文件在mysql数据库运行
2. 启动springboot项目
3. `rest-api.http`文件是idea中http-client插件的文件，如果不是该IDE，可按照下面接口自行ceshi
```
#User接口API
#获得全部用户信息
GET http://localhost:8080//getAllUserInfo
Accept: application/json

###

#增加用户信息
POST http://127.0.0.1:8080/addUserInfo
Content-Type: application/json

{
  "id": 5,
  "name": "小米",
  "sex": "男"
}

###
#根据用户id查询用户信息
GET http://localhost:8080//getUserInfoByID/5
Accept: application/json
###

POST http://127.0.0.1:8080/updateUserNameByID
Content-Type: application/json

{
  "id": 5,
  "name": "华为"
}
###

#根据用户id删除用户信息
GET http://localhost:8080/deleteUserInfoByID/5
Accept: application/json
###

#People 接口API
#获取全部人员信息
GET http://localhost:8080/getAllPeopleInfo
Accept: application/json

###

#增加人员信息
POST http://localhost:8080/addPeopleInfo
Content-Type: application/json

{
  "id": 5,
  "name": "keer",
  "address": "北疆",
  "age": 25
}



###

#根据id查询人员信息
GET http://localhost:8080/getPeopleInfoByID/5
Content-Type: application/json

###

#根据人员id修改人员姓名
POST http://localhost:8080/updatePeopleNameByID
Content-Type: application/json

{
  "id": 5,
  "name": "可耳"
}



###

#根据人员id删除人员信息
GET http://localhost:8080/deletePeopleInfoByID/5
Content-Type: application/json

###
```