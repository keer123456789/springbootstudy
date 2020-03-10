# springboot 邮件服务

## 1. 介绍
主要是使用springboot发送邮件的4种方式

## 2.使用说明

1. 将配置文件`application.properties`中的`spring.mail.password`和`spring.mail.username`
换成自己的邮箱配置，如果不是qq邮箱，其他配置自行更换。qq邮箱的配置在CSDN博客
中已经介绍：[https://blog.csdn.net/weixin_41938180/article/details/104723587](https://blog.csdn.net/weixin_41938180/article/details/104723587)

2. 每种邮件发送方式都在测试文件中`MailServiceTest`，运行每个测试方法即可发送邮件。