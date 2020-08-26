package com.wuhan.mall.service;

import com.wuhan.mall.dao.ClientMapper;
import com.wuhan.mall.entity.Client;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public List<Client> getClientList(){
        return clientMapper.getClientList();
    }

}
