package com.wuhan.mall.service;

import com.wuhan.mall.dao.LoginMapper;
import com.wuhan.mall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    LoginMapper loginMapper;

    public User login( String loginAccont, String password){
        return loginMapper.login(loginAccont, password);
    }
}
