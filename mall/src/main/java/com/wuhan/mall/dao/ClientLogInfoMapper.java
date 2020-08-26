package com.wuhan.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhan.mall.entity.ClientLogInfo;

import java.util.List;

public interface ClientLogInfoMapper extends BaseMapper<ClientLogInfo> {

    int addRecord(ClientLogInfo clientLogInfo);

    List<ClientLogInfo>  getClientLogInfoList(Integer clientId);

}
