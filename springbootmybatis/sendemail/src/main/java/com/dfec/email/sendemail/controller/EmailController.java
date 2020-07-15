package com.dfec.email.sendemail.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/10 17:04
 * @describe
 **/
@RestController
public class EmailController {
    @RequestMapping(value = "/sendemail")
    public String sendEmail() throws MessagingException, IOException {
        sendmail();
        return "Email 发送成功！！！";
    }

    private void sendmail() throws MessagingException, IOException {
        Properties props = new Properties();

        props.put("mail.smtp.starttls.enable", "true");
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
        props.put("mail.smtp.port", "587");
        // 此处填写你的账号
       // props.put("mail.user", "xxxxxxx@qq.com");
        // 此处的密码就是前面说的16位STMP口令
        //props.put("mail.password", "xxxxxxxxxxxxxxxxxxx");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("784084845@qq.com", "*******");
            }
        });
        Message msg = new MimeMessage(session);
        // 设置发件人
        msg.setFrom(new InternetAddress("784084845@qq.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("784084845@qq.com"));
        msg.setSubject("Spring Boot qsg email");
        msg.setContent("Spring Boot qsg email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Spring Boot qsg email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("main/resources/file/English.png");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);

    }
}
