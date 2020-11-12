package com.wuhan.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhan.mall.entity.Product;
import com.wuhan.mall.entity.ProductAttribute;
import com.wuhan.mall.vo.ProductVo;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {

    int addProduct(Product product);

    int addProductAttr(ProductAttribute productAttribute);

    int delProduct(Integer id);

    int delProductAttr(Integer id);

    int modifyProduct(Product product);

    int modifyProductAttr(ProductAttribute productAttribute);

    List<Product> getProductList();

    List<ProductVo> getProductVoList(Integer proId);

    Product getProductById(Integer id);

    List<ProductAttribute> getProductAttrById(Integer productId);

}
