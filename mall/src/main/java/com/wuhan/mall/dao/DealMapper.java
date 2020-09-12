package com.wuhan.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhan.mall.entity.DealInfo;
import com.wuhan.mall.vo.DealInfoVo;

import java.util.List;

public interface DealMapper  extends BaseMapper<DealInfo> {

    List<DealInfoVo> getDealInfoList(String startDate,String endDate);

}
