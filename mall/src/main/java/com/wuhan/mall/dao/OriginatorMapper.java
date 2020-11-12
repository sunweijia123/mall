package com.wuhan.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhan.mall.entity.Originator;

import java.util.List;

public interface OriginatorMapper extends BaseMapper<Originator> {

    List<Originator> getList();

    List<Originator> getValidList();

    Integer getMoneyCount(Integer id);
}
