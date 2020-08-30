package com.wuhan.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhan.mall.entity.User;
import com.wuhan.mall.entity.UserAccount;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper extends BaseMapper<UserAccount> {

    User getUser(String loginAccont);

    User login(@Param("loginAccont")String loginAccont, @Param("password")String password);

    User register(User user);

    int registerLoginInfo(UserAccount userAccount);

    int  modifyPassword(@Param("newPassword")String newPassword,
                         @Param("userId")int userId);
}
