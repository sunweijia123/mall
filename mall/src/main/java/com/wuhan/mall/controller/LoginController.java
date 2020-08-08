package com.wuhan.mall.controller;

import com.wuhan.mall.entity.User;
import com.wuhan.mall.service.LoginService;
import com.wuhan.mall.vo.JsonResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
            return JsonResult.FAILED();
        }

        User user = loginService.login(userName, password);
        return JsonResult.OK(user);
    }
}

