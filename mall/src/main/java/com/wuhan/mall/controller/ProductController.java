package com.wuhan.mall.controller;

import com.wuhan.mall.entity.Product;
import com.wuhan.mall.entity.ProductAttribute;
import com.wuhan.mall.service.ProductService;
import com.wuhan.mall.util.EmptyUtil;
import com.wuhan.mall.util.PageBean;
import com.wuhan.mall.vo.JsonResult;
import com.wuhan.mall.vo.ProductReq;
import com.wuhan.mall.vo.ProductVo;
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
    public JsonResult addProduct(@RequestBody ProductReq productReq){
        if(!Objects.nonNull(productReq) || EmptyUtil.isEmpty(productReq.getProductAttributes())){
            return JsonResult.FAILED("参数错误！");
        }
        int result = productService.addProduct(productReq);
        return JsonResult.OK(result);
    }

    @PostMapping("/addProductAttr")
    public JsonResult addProductAttr(@RequestBody ProductAttribute productAttribute){
        if(!Objects.nonNull(productAttribute)){
            return JsonResult.FAILED("参数错误！");
        }
        int result = productService.addProductAttr(productAttribute);
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

    @GetMapping("/delProductAttr")
    public JsonResult delProductAttr(@RequestParam("id") Integer id){
        if(id == null || id == 0){
            return JsonResult.FAILED("参数错误！");
        }

        int result = productService.delProductAttr(id);
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

    @PostMapping("/modifyProductAttr")
    public JsonResult modifyProductAttr(@RequestBody ProductAttribute productAttribute){
        if(!Objects.nonNull(productAttribute)){
            return JsonResult.FAILED("参数错误！");
        }
        int result = productService.modifyProductAttr(productAttribute);
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
        Long totalPages = (Long)map.get("totalPages");
        return JsonResult.OKList(data,pageNum,pageSize,total,totalPages);
    }

    @GetMapping("/getList")
    public JsonResult getList(){
        return JsonResult.OK(productService.getList());
    }

    @GetMapping("/getProductById")
    public JsonResult getProductById(@RequestParam("id")Integer id){
        return JsonResult.OK(productService.getProductById(id));
    }

    @GetMapping("/getProductAttrById")
    public JsonResult getProductAttrById(@RequestParam("productId")Integer id){
        return JsonResult.OK(productService.getProductAttrById(id));
    }

    @GetMapping("/getProductAttrList")
    public JsonResult getProductAttrList(@RequestParam("proId") Integer proId){
        if(proId == null || proId == 0){
            return JsonResult.FAILED("参数错误！");
        }
        List<ProductVo> productAttrList = productService.getProductAttrList(proId);
        return JsonResult.OK(productAttrList);
    }


}
