package com.wuhan.mall.vo;

import com.wuhan.mall.entity.Product;
import com.wuhan.mall.entity.ProductAttribute;
import lombok.Data;

import java.util.List;

@Data
public class ProductReq extends Product {

    List<ProductAttribute> productAttributes;
}
