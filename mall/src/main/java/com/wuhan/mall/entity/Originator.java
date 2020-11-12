package com.wuhan.mall.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Originator extends BaseEntity{

    private String name;

    private String phone;

    //投入金额
    private int money;

    //股份占比
    private String ratio;

    //状态（0正常，1退出）
    private int status;

    //参加时间
    private String date;

}
