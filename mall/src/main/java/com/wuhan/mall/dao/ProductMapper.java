package com.wuhan.mall.dao;

import com.wuhan.mall.entity.Product;

import java.util.List;

public interface ProductMapper {

    int addProduct(Product product);

    int delProduct(Integer id);

    int modifyProduct(Product product);

    List<Product> getProductList();
}
