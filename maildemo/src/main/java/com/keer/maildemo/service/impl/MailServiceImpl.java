package com.keer.maildemo.service.impl;

import com.keer.maildemo.pojo.User;
import com.keer.maildemo.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.lang.reflect.Field;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.maildemo.service.impl
 * @Author: keer
 * @CreateTime: 2020-03-07 10:32
 * @Description: 邮件接口实现类
 */
@Service
public class MailServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${senderMail}")
    private String senderMail;
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void sendSimpleMail(String receiverMail, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderMail);
        message.setTo(receiverMail);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            logger.info("简单邮件已经发送");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("简单邮件发送失败！！！");
        }
    }

    @Override
    public void sendHtmlMail(String receiverMail, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(senderMail);
            helper.setTo(receiverMail);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            logger.info("html邮件发送成功！！");
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("html邮件发送是异常");
        }
    }

    @Override
    public void sendAttachmentsMail(String receiverMail, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(senderMail);
            helper.setTo(receiverMail);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String filename = file.getFile().getName();
            helper.addAttachment(filename, file);

            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");

        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("发送带附件的邮件时发生异常！");
        }

    }

    @Override
    public void sendThymeleafMail(String receiverMail, String subject, User user) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(senderMail);
            helper.setTo(receiverMail);
            helper.setSubject(subject);

            Context context = new Context();
            context.setVariable("username", user.getName());
            context.setVariable("num", user.getNum());
            context.setVariable("department", user.getDepartment());
            String process = templateEngine.process("mail.html", context);

            helper.setText(process, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
