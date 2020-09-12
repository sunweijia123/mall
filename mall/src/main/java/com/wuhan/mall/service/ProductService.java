package com.wuhan.mall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuhan.mall.dao.ProductMapper;
import com.wuhan.mall.entity.ClientLogInfo;
import com.wuhan.mall.entity.Product;
import com.wuhan.mall.entity.ProductAttribute;
import com.wuhan.mall.util.PageBean;
import com.wuhan.mall.vo.ProductReq;
import com.wuhan.mall.vo.ProductVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Resource
    ProductMapper productMapper;

    public int addProduct(ProductReq productReq){
        Product product = new Product();
        BeanUtils.copyProperties(productReq,product);
        productMapper.addProduct(product);
        productReq.getProductAttributes().forEach(attr ->{
            attr.setProductId(product.getId());
            productMapper.addProductAttr(attr);
        });
        return 1;
    }

    public int addProductAttr(ProductAttribute productAttribute){
        return productMapper.addProductAttr(productAttribute);
    }

    public int delProduct(Integer id){
        return productMapper.delProduct(id);
    }

    public int delProductAttr(Integer id){
        return productMapper.delProductAttr(id);
    }

    public int modifyProduct(Product product){
        return productMapper.modifyProduct(product);
    }

    public int modifyProductAttr(ProductAttribute productAttribute){
        return productMapper.modifyProductAttr(productAttribute);
    }

    //分页获取列表
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

    //获取下拉列表
    public List<Product> getList(){
        return productMapper.getProductList();
    }

    //根据产品id获取包装规格和价格
    public List<ProductVo> getProductAttrList(Integer proId){
        return productMapper.getProductVoList(proId);
    }
}
