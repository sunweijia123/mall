package com.wuhan.mall.dao;

import com.wuhan.mall.entity.User;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

    User login(@Param("loginAccont")String loginAccont, @Param("password")String password);
}
