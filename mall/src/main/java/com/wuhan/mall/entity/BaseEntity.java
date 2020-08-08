package com.wuhan.mall.entity;

import lombok.Data;

import java.util.Date;

/*
    基础实体类
 */
@Data
public class BaseEntity {

    private Integer id;

    private Date createTime;

    private Date updateTime;

}
