package com.wuhan.mall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuhan.mall.dao.ClientMapper;
import com.wuhan.mall.entity.Client;
import com.wuhan.mall.entity.ClientLogInfo;
import com.wuhan.mall.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {

    @Resource
    ClientMapper clientMapper;

    public int addClient(Client client){
        return clientMapper.addClient(client);
//        return clientMapper.insert(client);
    }

    public int delClient(Integer id){
        return clientMapper.delClient(id);
    }

    public int  modifyClient(Client client){
        return clientMapper.modifyClient(client);
    }

    public Client getClient(Integer id){
        return clientMapper.getClient(id);
    }

    public Map<String,Object> getClientList(PageBean pageBean){
        Map<String,Object> result = new HashMap<>();
        if(pageBean!=null && pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }
        List<Client> clientList = clientMapper.getClientList();
        result.put("data",clientList);
        if(pageBean!=null && pageBean.isPagination()){
            PageInfo<Client> pageInfo =new PageInfo<>(clientList);
            result.put("page",pageInfo.getPageNum());
            result.put("pageSize",pageInfo.getPageSize());
            result.put("total",pageInfo.getTotal());
        }
        return result;
    }

}
