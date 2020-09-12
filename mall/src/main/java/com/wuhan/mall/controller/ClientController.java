package com.wuhan.mall.controller;

import com.wuhan.mall.entity.Client;
import com.wuhan.mall.service.ClientService;
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
@RequestMapping("/mall/client")
public class ClientController {

    @Resource
    ClientService clientService;

    @PostMapping(value = "/addClient")
    public JsonResult addClient(@RequestBody @Validated Client client, BindingResult bindingResult){
        if(!Objects.nonNull(client)){
            return JsonResult.FAILED("参数错误！");
        }
        if (bindingResult.hasErrors()) {
            return JsonResult.FAILED(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        int result = clientService.addClient(client);
        return JsonResult.OK(result);
    }

    @RequestMapping("/delClient")
    public JsonResult delClient(@RequestParam("id") Integer id){
        if(null == id){
            return JsonResult.FAILED("参数错误！");
        }
        int result = clientService.delClient(id);
        return JsonResult.OK(result);
    }

    @PostMapping(value = "/modifyClient")
    public JsonResult modifyClient(@RequestBody @Validated Client client, BindingResult bindingResult){
        if(!Objects.nonNull(client)){
            return JsonResult.FAILED("参数错误！");
        }
        if (bindingResult.hasErrors()) {
            return JsonResult.FAILED(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        int result = clientService.modifyClient(client);
        return JsonResult.OK(result);
    }

    @RequestMapping("/getClient")
    public JsonResult getClient(@RequestParam("id") Integer id){
        if(null == id){
            return JsonResult.FAILED("参数错误！");
        }
        Client client = clientService.getClient(id);
        return JsonResult.OK(client);
    }

    @RequestMapping("/getClientList")
    public JsonResult getClientList(@RequestParam("page") Integer page){
        if(page == null){
            page = 1;
        }
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        Map<String, Object> map = clientService.getClientList(pageBean);
        List<Client> data = (List<Client>)map.get("data");
        Integer pageNum = (Integer)map.get("page");
        Integer pageSize = (Integer)map.get("pageSize");
        Long total = (Long)map.get("total");
        return JsonResult.OKList(data,pageNum,pageSize,total);
    }

    @RequestMapping("/getList")
    public JsonResult getList(){
       return JsonResult.OK(clientService.getList());
    }

}
