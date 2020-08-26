package com.wuhan.mall.service;

import com.wuhan.mall.dao.ClientLogInfoMapper;
import com.wuhan.mall.entity.ClientLogInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientLogInfoService {

    @Resource
    ClientLogInfoMapper clientLogInfoMapper;

    public int addRecord(ClientLogInfo clientLogInfo){
        return clientLogInfoMapper.addRecord(clientLogInfo);
    }

    public List<ClientLogInfo> getClientLogInfoList(Integer clientId){
        return clientLogInfoMapper.getClientLogInfoList(clientId);
    }
}
