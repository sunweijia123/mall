package com.wuhan.mall.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ClientLogInfo extends BaseEntity{

    //客户id
    @NotNull(message = "客户id不能为空！")
    private Integer clientId;

    //拜访时间
    @NotBlank(message = "拜访时间不能为空！")
    private String visitTime;

    //拜访信息
    @NotBlank(message = "拜访信息不能为空！")
    private String visitInfo;

}
