package com.wuhan.mall.service;

import com.wuhan.mall.dao.LoginMapper;
import com.wuhan.mall.entity.User;
import com.wuhan.mall.entity.UserAccount;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class LoginService {

    @Resource
    LoginMapper loginMapper;

    //登录查询
    public User login( String loginAccont, String password){
        return loginMapper.login(loginAccont, password);
    }

    private Date date = new Date();
    //注册user
    public User register(User user){
        user.setCreateTime(date);
        user.setUpdateTime(date);
        loginMapper.register(user);
        return user;
    }

    //注册LoginInfo
    public void registerLoginInfo(UserAccount userAccount){
        userAccount.setCreateTime(date);
        userAccount.setUpdateTime(date);
        loginMapper.registerLoginInfo(userAccount);
    }

    //修改密码
    public void modifyPassword(String newPassword,int userId){
        loginMapper.modifyPassword(newPassword,userId);
    }
}
