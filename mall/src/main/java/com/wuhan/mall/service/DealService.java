package com.wuhan.mall.service;

import com.wuhan.mall.dao.DealMapper;
import com.wuhan.mall.entity.DealInfo;
import com.wuhan.mall.vo.DealInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DealService {

    @Resource
    DealMapper dealMapper;

    public int addDealInfo(DealInfo dealInfo){
        Date date = new Date();
        dealInfo.setId(0);
        dealInfo.setCreateTime(date);
        dealInfo.setUpdateTime(date);
        return dealMapper.insert(dealInfo);
    }

    public int updateDealInfo (DealInfo dealInfo){
        Date date = new Date();
        dealInfo.setUpdateTime(date);
        return dealMapper.updateById(dealInfo);
    }


    public List<DealInfoVo> getDealInfoList(String startDate,String endDate){
        return dealMapper.getDealInfoList(startDate,endDate);
    }

}
