package com.wuhan.mall.controller;

import com.wuhan.mall.entity.ClientLogInfo;
import com.wuhan.mall.service.ClientLogInfoService;
import com.wuhan.mall.util.PageBean;
import com.wuhan.mall.vo.JsonResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/mall/logInfo")
public class ClientLogInfoController {

    @Resource
    ClientLogInfoService clientLogInfoService;

    @PostMapping(value = "/addRecord")
    public JsonResult addRecord(@RequestBody @Validated ClientLogInfo clientLogInfo, BindingResult bindingResult){
        if(!Objects.nonNull(clientLogInfo)){
            return JsonResult.FAILED("参数错误！");
        }
        if (bindingResult.hasErrors()) {
            return JsonResult.FAILED(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        int result = clientLogInfoService.addRecord(clientLogInfo);
        return JsonResult.OK(result);
    }

    @RequestMapping("/getClientLogInfoList")
    public JsonResult getClientLogInfoList(@RequestParam("id") Integer clientId,
                                           @RequestParam("page") Integer page){
        if(clientId == null){
            return JsonResult.FAILED("参数错误！");
        }
        if(page == null){
            page = 1;
        }
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);

        Map<String, Object> map = clientLogInfoService.getClientLogInfoList(clientId, pageBean);
        List<ClientLogInfo> data = (List<ClientLogInfo>)map.get("data");
        Integer pageNum = (Integer)map.get("page");
        Integer pageSize = (Integer)map.get("pageSize");
        Long total = (Long)map.get("total");
        Long totalPages = (Long)map.get("totalPages");
        return JsonResult.OKList(data,pageNum,pageSize,total,totalPages);
    }

}
