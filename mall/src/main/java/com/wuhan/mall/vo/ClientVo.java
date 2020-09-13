package com.wuhan.mall.vo;

import com.wuhan.mall.entity.Client;
import lombok.Data;

@Data
public class ClientVo extends Client {

    //是否是意向客户  0 未合作   1 已合作   2 意向客户
    private String cooperation;
}
