package com.wuhan.mall.entity;

import lombok.Data;

/*
    用户实体
 */
@Data
public class User extends BaseEntity {

    private String name;

    private String avatar;

    private String email;

}
