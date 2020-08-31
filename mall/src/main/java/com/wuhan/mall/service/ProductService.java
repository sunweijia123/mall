package com.wuhan.mall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuhan.mall.dao.ProductMapper;
import com.wuhan.mall.entity.ClientLogInfo;
import com.wuhan.mall.entity.Product;
import com.wuhan.mall.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Resource
    ProductMapper productMapper;

    public int addProduct(Product product){
      return productMapper.addProduct(product);
    }

    public int delProduct(Integer id){
        return productMapper.delProduct(id);
    }

    public int modifyProduct(Product product){
        return productMapper.modifyProduct(product);
    }

    public Map<String,Object> getProductList(PageBean pageBean){
        Map<String,Object> result = new HashMap<>();
        if(pageBean!=null && pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }
        List<Product> list = productMapper.getProductList();
        result.put("data",list);
        if(pageBean!=null && pageBean.isPagination()){
            PageInfo<Product> pageInfo =new PageInfo<>(list);
            result.put("page",pageInfo.getPageNum());
            result.put("pageSize",pageInfo.getPageSize());
            result.put("total",pageInfo.getTotal());
        }
        return result;
    }
}
