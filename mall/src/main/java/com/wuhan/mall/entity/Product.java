package com.wuhan.mall.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Product extends BaseEntity{

    private String name;

    private String avatar;

    private String type;

    //粘度
    private String viscosity;

    //质量级别
    private String qualityLevel;
}
