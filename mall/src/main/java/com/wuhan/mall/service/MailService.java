package com.wuhan.mall.service;

import com.wuhan.mall.dao.LoginMapper;
import com.wuhan.mall.dao.UserMapper;
import com.wuhan.mall.entity.User;
import com.wuhan.mall.util.EmptyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Slf4j
@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private LoginMapper loginMapper;

    public void sendSimpleMail(String to,String title,String password,User user) throws RuntimeException{
        loginMapper.modifyPassword(password,user.getId());
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(title);
        mailMessage.setText(user.getName() + ",您的新密码为：" + password);
        javaMailSender.send(mailMessage);
        log.info("邮件发送成功，To->"+to);
    }

}
