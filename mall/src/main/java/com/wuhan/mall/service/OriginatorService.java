package com.wuhan.mall.service;

import com.wuhan.mall.dao.OriginatorMapper;
import com.wuhan.mall.entity.Originator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OriginatorService {

    @Resource
    OriginatorMapper originatorMapper;

    public int addOriginator(Originator originator) {
        Date date = new Date();
        originator.setId(0);
        originator.setCreateTime(date);
        originator.setUpdateTime(date);
        calc(originator);
        return originatorMapper.insert(originator);
    }

    public int delOriginator(Integer id) {
        return originatorMapper.deleteById(id);
    }

    public int updateOriginator(Originator originator) {
        calc(originator);
        originator.setUpdateTime(new Date());
        return originatorMapper.updateById(originator);
    }

    public Originator getOriginator(Integer id) {
        return originatorMapper.selectById(id);
    }

    public List<Originator> getOriginatorList() {
        return originatorMapper.getList();
    }

    //计算比例
    private void calc(Originator originator) {
        Integer count = originatorMapper.getMoneyCount(originator.getId());
        if (count == null || count == 0) {
            originator.setRatio("100%");
        } else {
            int money = count + originator.getMoney();
            fillOriginator(money, originator);
            //修改其他人比例
            List<Originator> originatorList = originatorMapper.getValidList();
            originatorList.removeIf(item -> item.getId().equals(originator.getId()));
            for (Originator item : originatorList) {
                fillOriginator(money, item);
                originatorMapper.updateById(item);
            }
        }
    }

    private void fillOriginator(int money, Originator originator) {
        double ratio = new BigDecimal(((float) originator.getMoney() / (float) money) * 100).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        originator.setRatio(ratio + "%");
    }
}
