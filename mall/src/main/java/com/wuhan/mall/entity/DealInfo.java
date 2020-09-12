package com.wuhan.mall.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DealInfo extends BaseEntity{

    //客户id
    private int clientId;

    //产品id
    private int productId;

    //单价
    private int price;

    //售价
    private int sellPrice;

    //数量
    private int amount;

    //总价
    private int totalPrice;

    //折扣
    private String discount;

    //备注
    private String remark;

}
