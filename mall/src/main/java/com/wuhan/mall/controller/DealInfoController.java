package com.wuhan.mall.controller;

import com.wuhan.mall.entity.DealInfo;
import com.wuhan.mall.service.DealService;
import com.wuhan.mall.util.PageBean;
import com.wuhan.mall.vo.DealInfoVo;
import com.wuhan.mall.vo.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
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

    @RequestMapping("/getDealInfoList")
    public JsonResult getDealInfoList(@RequestParam("page") Integer page,
                                    @RequestParam(value = "startDate", required = false) String startDate,
                                    @RequestParam(value = "endDate", required = false) String endDate){
        if(page == null){
            page = 1;
        }
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        Map<String, Object> map = dealService.getDealInfoList(pageBean,startDate,endDate);
        List<DealInfoVo> data = (List<DealInfoVo>)map.get("data");
        Integer pageNum = (Integer)map.get("page");
        Integer pageSize = (Integer)map.get("pageSize");
        Long total = (Long)map.get("total");
        Long totalPages = (Long)map.get("totalPages");
        return JsonResult.OKList(data,pageNum,pageSize,total,totalPages);
    }

}
