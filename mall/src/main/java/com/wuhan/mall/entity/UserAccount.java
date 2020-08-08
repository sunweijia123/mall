package com.wuhan.mall.entity;

import lombok.Data;

/*
    账户信息实体
 */
@Data
public class UserAccount extends BaseEntity {

    private Integer userId;

    private String loginAccont;

        private String password;

}
