package com.wuhan.mall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuhan.mall.dao.ClientMapper;
import com.wuhan.mall.dao.DealMapper;
import com.wuhan.mall.dao.ProductMapper;
import com.wuhan.mall.entity.Client;
import com.wuhan.mall.entity.DealInfo;
import com.wuhan.mall.entity.Product;
import com.wuhan.mall.util.PageBean;
import com.wuhan.mall.vo.DealInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DealService {

    @Resource
    DealMapper dealMapper;
    @Resource
    ClientMapper clientMapper;
    @Resource
    ProductMapper productMapper;

    public int addDealInfo(DealInfo dealInfo) {
        this.calc(dealInfo);
        Date date = new Date();
        dealInfo.setId(0);
        dealInfo.setCreateTime(date);
        dealInfo.setUpdateTime(date);
        return dealMapper.insert(dealInfo);
    }

    public int updateDealInfo(DealInfo dealInfo) {
        this.calc(dealInfo);
        Date date = new Date();
        dealInfo.setUpdateTime(date);
        return dealMapper.updateById(dealInfo);
    }


    public Map<String, Object> getDealInfoList(PageBean pageBean, String startDate, String endDate) {

        Map<String, Object> result = new HashMap<>();
        if (pageBean != null && pageBean.isPagination()) {
            PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
        }
        List<DealInfoVo> dealInfoList = dealMapper.getDealInfoList(startDate, endDate);
        //补充客户名称和产品名称
        for (DealInfoVo dealInfoVo : dealInfoList) {
            Client client = clientMapper.getClient(dealInfoVo.getClientId());
            dealInfoVo.setClientName(client.getName());
            Product product = productMapper.getProductById(dealInfoVo.getProductId());
            dealInfoVo.setProductName(product.getName());
        }
        result.put("data", dealInfoList);
        if (pageBean != null && pageBean.isPagination()) {
            PageInfo<DealInfoVo> pageInfo = new PageInfo<>(dealInfoList);
            result.put("page", pageInfo.getPageNum());
            result.put("pageSize", pageInfo.getPageSize());
            result.put("total", pageInfo.getTotal());
            result.put("totalPages", pageInfo.getTotal() / pageInfo.getPageSize() + 1);
        }
        return result;
    }

    //计算价格
    private void calc(DealInfo dealInfo) {
        int counts = dealInfo.getAmount() * dealInfo.getSellPrice();//折扣总价
        int money = dealInfo.getAmount() * dealInfo.getPrice();//没折扣价格
        DecimalFormat format = new DecimalFormat("0.00");
        String discount = format.format((float) counts / money);
        dealInfo.setDiscount("1.00".equals(discount) ? "无折扣" : discount);
        dealInfo.setTotalPrice(counts);
        dealInfo.setDebt(counts - dealInfo.getProceeds());
    }

}
