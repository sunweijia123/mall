package com.wuhan.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhan.mall.entity.Client;

import java.util.List;

public interface ClientMapper  extends BaseMapper<Client> {

    int addClient(Client client);

    int delClient(Integer id);

    int modifyClient(Client client);

    Client getClient(Integer id);

    List<Client> getClientList();

}
