package com.wuhan.mall.service;

import com.wuhan.mall.dao.UserMapper;
import com.wuhan.mall.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getUserByEmail(String email){
        return userMapper.getUserByEmail(email);
    }

    public User modifyAvatar(User user){
        userMapper.modifyAvatar(user);
        return userMapper.getUserById(user.getId());
    }
}
