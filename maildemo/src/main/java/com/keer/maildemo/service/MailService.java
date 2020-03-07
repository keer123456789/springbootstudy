package com.keer.maildemo.service;

import com.keer.maildemo.pojo.User;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.maildemo.service
 * @Author: keer
 * @CreateTime: 2020-03-07 10:23
 * @Description: 发送邮件接口
 */
public interface MailService {
    /**
     * 发送简单的文字邮件
     *
     * @param receiverMail 接受者邮箱
     * @param subject      邮件主题
     * @param content      邮件内容
     */
    void sendSimpleMail(String receiverMail, String subject, String content);

    /**
     * 发送html文件的邮件
     *
     * @param receiverMail 接受者邮箱
     * @param subject      邮件主题
     * @param content      邮件内容
     */
    void sendHtmlMail(String receiverMail, String subject, String content);

    /**
     * 发送带有附件的邮件
     *
     * @param receiverMail 接受者邮箱
     * @param subject      邮件主题
     * @param content      邮件内容
     * @param filePath     附件文件地址
     */
    void sendAttachmentsMail(String receiverMail, String subject, String content, String filePath);

    /**
     * 发送模板文件
     *
     * @param receiverMail 接受者邮箱
     * @param subject      邮件主题
     * @param user         发送模板信息
     */
    void sendThymeleafMail(String receiverMail, String subject, User user);

}
