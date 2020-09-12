package com.wuhan.mall.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ProductAttribute extends BaseEntity {

    //产品id
    private int productId;

    //包装规格
    private String pack;

    //出厂价
    private Integer price;

}
