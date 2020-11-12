package com.wuhan.mall.controller;

import com.wuhan.mall.entity.Originator;
import com.wuhan.mall.service.OriginatorService;
import com.wuhan.mall.util.EmptyUtil;
import com.wuhan.mall.vo.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("/originator")
public class OriginatorController {

    @Resource
    OriginatorService originatorService;

    @PostMapping("/addOriginator")
    public JsonResult addOriginator(@RequestBody Originator originator){
        if(!Objects.nonNull(originator)){
            return JsonResult.FAILED("参数错误！");
        }

        return JsonResult.OK(originatorService.addOriginator(originator));
    }

    @GetMapping("/delOriginator")
    public JsonResult delOriginator(Integer id){
        if(EmptyUtil.isEmpty(id)){
            return JsonResult.FAILED("参数错误！");
        }
        return JsonResult.OK(originatorService.delOriginator(id));
    }

    @PostMapping("/updateOriginator")
    public JsonResult updateOriginator(@RequestBody Originator originator){
        if(!Objects.nonNull(originator)){
            return JsonResult.FAILED("参数错误！");
        }

        return JsonResult.OK(originatorService.updateOriginator(originator));
    }

    @GetMapping("/getOriginator")
    public JsonResult getOriginator(Integer id){
        if(EmptyUtil.isEmpty(id)){
            return JsonResult.FAILED("参数错误！");
        }
        return JsonResult.OK(originatorService.getOriginator(id));
    }

    @GetMapping("/getOriginatorList")
    public JsonResult getOriginatorList(){
        return JsonResult.OK(originatorService.getOriginatorList());
    }
}
