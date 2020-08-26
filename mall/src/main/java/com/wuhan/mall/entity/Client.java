package com.wuhan.mall.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Client extends BaseEntity {

    //客户姓名
    @NotBlank(message = "客户姓名不能为空")
    private String name;

    //客户电话
    @Pattern(regexp = "^1[3|4|5|7|8][0-9]\\d{4,8}$",message = "手机号格式不正确")
    private String phone;

    //客户地址
    @NotBlank(message = "客户地址不能为空")
    private String address;

    //客户房屋地址
    @NotBlank(message = "客户房屋地址不能为空")
    private String houseInfo;

    //客户人员信息
    @NotBlank(message = "客户人员信息不能为空")
    private String peopleInfo;

    //客户主营产品信息
    @NotBlank(message = "客户主营产品信息不能为空")
    private String productInfo;

}
