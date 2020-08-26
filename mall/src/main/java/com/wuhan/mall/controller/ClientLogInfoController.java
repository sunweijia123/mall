package com.wuhan.mall.controller;

import com.wuhan.mall.entity.ClientLogInfo;
import com.wuhan.mall.service.ClientLogInfoService;
import com.wuhan.mall.vo.JsonResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/mall/logInfo")
public class ClientLogInfoController {

    @Resource
    ClientLogInfoService clientLogInfoService;

    @RequestMapping(value = "/addRecord",method = RequestMethod.POST)
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
    public JsonResult getClientLogInfoList(@RequestParam("id") Integer clientId){
        if(clientId == null){
            return JsonResult.FAILED("参数错误！");
        }
        List<ClientLogInfo> logInfoList = clientLogInfoService.getClientLogInfoList(clientId);
        return JsonResult.OK(logInfoList);
    }

}
