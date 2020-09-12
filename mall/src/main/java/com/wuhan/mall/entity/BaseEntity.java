package com.wuhan.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/*
    基础实体类
 */
@Data
 class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Date createTime;

    private Date updateTime;

}
