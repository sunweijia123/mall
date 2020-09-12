package com.wuhan.mall.vo;

import com.wuhan.mall.entity.DealInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DealInfoVo extends DealInfo {

    private String productName;

    private String clientName;

    //毛利润
    private int profit;

}
