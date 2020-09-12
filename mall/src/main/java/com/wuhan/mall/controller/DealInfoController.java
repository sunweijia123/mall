package com.wuhan.mall.controller;

import com.wuhan.mall.entity.DealInfo;
import com.wuhan.mall.service.DealService;
import com.wuhan.mall.vo.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("/mall/dealInfo")
public class DealInfoController {

    @Resource
    DealService dealService;

    @PostMapping("/addDealInfo")
    public JsonResult addDealInfo(@RequestBody DealInfo dealInfo){

        if(!Objects.nonNull(dealInfo)){
            return JsonResult.FAILED("参数错误！");
        }

        int result = dealService.addDealInfo(dealInfo);
        return JsonResult.OK(result);
    }

    @PostMapping("/updateDealInfo")
    public JsonResult updateDealInfo(@RequestBody DealInfo dealInfo){

        if(!Objects.nonNull(dealInfo)){
            return JsonResult.FAILED("参数错误！");
        }

        int result = dealService.updateDealInfo(dealInfo);
        return JsonResult.OK(result);
    }

}
