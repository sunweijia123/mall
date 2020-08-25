package com.wuhan.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhan.mall.entity.User;

public interface UserMapper extends BaseMapper<User> {

    User getUserByEmail(String email);
}
