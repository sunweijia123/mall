package com.wuhan.mall.controller;

import com.wuhan.mall.entity.Product;
import com.wuhan.mall.service.ProductService;
import com.wuhan.mall.util.PageBean;
import com.wuhan.mall.vo.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductService productService;

    @PostMapping("/addProduct")
    public JsonResult addProduct(@RequestBody Product product){
        if(!Objects.nonNull(product)){
            return JsonResult.FAILED("参数错误！");
        }
        int result = productService.addProduct(product);
        return JsonResult.OK(result);
    }

    @GetMapping("/delProduct")
    public JsonResult delProduct(@RequestParam("id") Integer id){
        if(id == null || id == 0){
            return JsonResult.FAILED("参数错误！");
        }

        int result = productService.delProduct(id);
        return JsonResult.OK(result);
    }

    @PostMapping("/modifyProduct")
    public JsonResult modifyProduct(@RequestBody Product product){
        if(!Objects.nonNull(product)){
            return JsonResult.FAILED("参数错误！");
        }
        int result = productService.modifyProduct(product);
        return JsonResult.OK(result);
    }

    @GetMapping("/getProductList")
    public JsonResult getProductList(@RequestParam("page") Integer page){
        if(page == null){
            page = 1;
        }
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);

        Map<String, Object> map = productService.getProductList(pageBean);
        List<Product> data = (List<Product>)map.get("data");
        Integer pageNum = (Integer)map.get("page");
        Integer pageSize = (Integer)map.get("pageSize");
        Long total = (Long)map.get("total");
        return JsonResult.OKList(data, pageNum,pageSize,total);
    }
}
