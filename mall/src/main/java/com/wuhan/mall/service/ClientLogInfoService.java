package com.wuhan.mall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuhan.mall.dao.ClientLogInfoMapper;
import com.wuhan.mall.entity.ClientLogInfo;
import com.wuhan.mall.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientLogInfoService {

    @Resource
    ClientLogInfoMapper clientLogInfoMapper;

    public int addRecord(ClientLogInfo clientLogInfo){
        return clientLogInfoMapper.addRecord(clientLogInfo);
    }

    public Map<String,Object> getClientLogInfoList(Integer clientId, PageBean pageBean){
        Map<String,Object> result = new HashMap<>();
        if(pageBean!=null && pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        List<ClientLogInfo> logInfoList = clientLogInfoMapper.getClientLogInfoList(clientId);
        result.put("data",logInfoList);
        if(pageBean!=null && pageBean.isPagination()){
            PageInfo<ClientLogInfo> pageInfo =new PageInfo<>(logInfoList);
            result.put("page",pageInfo.getPageNum());
            result.put("pageSize",pageInfo.getPageSize());
            result.put("total",pageInfo.getTotal());
        }
        return result;
    }
}
