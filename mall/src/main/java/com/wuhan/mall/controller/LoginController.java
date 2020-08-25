package com.wuhan.mall.controller;

import com.wuhan.mall.entity.User;
import com.wuhan.mall.entity.UserAccount;
import com.wuhan.mall.service.LoginService;
import com.wuhan.mall.vo.JsonResult;
import com.wuhan.mall.vo.RegisterVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mall")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public JsonResult login(@RequestParam("name") String userName,
                            @RequestParam("password") String password){
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            return JsonResult.FAILED("登录信息不能为空！");
        }

        User user = loginService.login(userName, password);
        return JsonResult.OK(user);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JsonResult register(RegisterVo registerVo){
        if(registerVo == null){
            return JsonResult.FAILED("注册失败！");
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
    public JsonResult register(@RequestParam("newPassword")String newPassword,
                               @RequestParam("userId")int userId){
        loginService.modifyPassword(newPassword,userId);
        return  JsonResult.OK("修改成功，密码为："+newPassword);
    }
}

