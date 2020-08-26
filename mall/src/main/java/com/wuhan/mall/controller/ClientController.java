package com.wuhan.mall.controller;

import com.wuhan.mall.entity.Client;
import com.wuhan.mall.service.ClientService;
import com.wuhan.mall.vo.JsonResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/mall/client")
public class ClientController {

    @Resource
    ClientService clientService;

    @RequestMapping(value = "/addClient",method = RequestMethod.POST)
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

    @RequestMapping(value = "/modifyClient",method = RequestMethod.POST)
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
    public JsonResult getClientList(){
        List<Client> clientList = clientService.getClientList();
        return JsonResult.OK(clientList);
    }

}
