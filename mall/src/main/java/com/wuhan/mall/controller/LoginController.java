package com.wuhan.mall.controller;

import com.wuhan.mall.entity.User;
import com.wuhan.mall.entity.UserAccount;
import com.wuhan.mall.service.LoginService;
import com.wuhan.mall.vo.JsonResult;
import com.wuhan.mall.vo.RegisterVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/mall")
@Transactional
public class LoginController {

    @Resource
    LoginService loginService;

    @GetMapping("/login")
    public JsonResult login(@RequestParam("name") String userName,
                            @RequestParam("password") String password){
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            return JsonResult.FAILED("登录信息不能为空！");
        }

        User loginServiceUser = loginService.getUser(userName);
        if(loginServiceUser == null){
            return JsonResult.FAILED("请先注册用户，再登录！");
        }

        User user = loginService.login(userName, password);

        if(user == null){
            return JsonResult.FAILED("密码错误，请重试！");
        }
        return JsonResult.OK(user);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JsonResult register(@RequestBody @Validated RegisterVo registerVo, BindingResult bindingResult){
        if(registerVo == null){
            return JsonResult.FAILED("注册失败！");
        }
        if (bindingResult.hasErrors()) {
            return JsonResult.FAILED(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        User user = new User();
        UserAccount userAccount = new UserAccount();
        BeanUtils.copyProperties(registerVo,user);
        BeanUtils.copyProperties(registerVo,userAccount);

        User rtnUser = loginService.register(user);
        userAccount.setUserId(rtnUser.getId());
        loginService.registerLoginInfo(userAccount);

        return  JsonResult.OK(rtnUser);
    }

    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST)
    public JsonResult modifyPassword(@RequestParam("newPassword")String newPassword,
                               @RequestParam("userId")int userId){
        loginService.modifyPassword(newPassword,userId);
        return  JsonResult.OK("修改成功，密码为："+newPassword);
    }
}

