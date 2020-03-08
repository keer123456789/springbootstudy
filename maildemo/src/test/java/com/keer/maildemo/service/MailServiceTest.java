package com.keer.maildemo.service;


import com.keer.maildemo.pojo.User;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.maildemo.service
 * @Author: keer
 * @CreateTime: 2020-03-07 10:52
 * @Description: 邮件接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("邮件接口测试")
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    @Test
    @DisplayName("发送简单邮件")
    public void testSimpleMail() {
        mailService.sendSimpleMail("15110074528@163.com", "Test use springboot send mail", "简单邮件测试文件");
    }

    @Test
    @DisplayName("发送html邮件")
    public void testHtmlMail() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html><body><h1>使用springboot 发送html邮件 测试文件！！！</h1>")
                .append("<p >测试成功</p>")
                .append("<p >测试时间" + new Date() + "</p></body></html>");
        mailService.sendHtmlMail("15110074528@163.com", "Test use springboot send mail", sb.toString());
    }

    @Test
    @DisplayName("发送附件邮件")
    public void testAttachmentsMail() {
        String path = "./testMailFile.txt";
        StringBuffer sb = new StringBuffer();
        sb.append("<html><body><h1>使用springboot 发送附件邮件 测试文件！！！</h1>")
                .append("<p >测试成功</p>")
                .append("<p >测试时间" + new Date() + "</p></body></html>");
        mailService.sendAttachmentsMail("15110074528@163.com", "Test use springboot send mail", sb.toString(), path);
    }

    @Test
    @DisplayName("发送模板html邮件")
    public void testThymeleafMail() {
        User user = new User();
        user.setName("王国连");
        user.setNum("135");
        user.setDepartment("教务处");
        mailService.sendThymeleafMail("15110074528@163.com", "Test use springboot send mail", user);

    }


}
