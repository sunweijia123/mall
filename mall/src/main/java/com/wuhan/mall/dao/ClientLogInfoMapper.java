package com.wuhan.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhan.mall.entity.ClientLogInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientLogInfoMapper extends BaseMapper<ClientLogInfo> {

    int addRecord(ClientLogInfo clientLogInfo);

    List<ClientLogInfo>  getClientLogInfoList(@Param("clientId") Integer clientId);

}
