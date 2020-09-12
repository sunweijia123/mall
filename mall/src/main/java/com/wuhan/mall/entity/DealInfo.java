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

    //包装规格
    private String pack;

    //单价
    private int price;

    //售价
    private int sellPrice;

    //数量
    private int amount;

    //总价
    private int totalPrice;

    //实际收款
    private int proceeds;

    //欠款
    private int debt;

    //折扣
    private String discount;

    //促销备注
    private String saleRemark;

    //欠款备注
    private String debtRemark;

    //其他备注
    private String remark;

}
