package com.wuhan.mall.controller;


import com.wuhan.mall.entity.User;
import com.wuhan.mall.service.MailService;
import com.wuhan.mall.service.UserService;
import com.wuhan.mall.util.EmptyUtil;
import com.wuhan.mall.util.UUIDUtil;
import com.wuhan.mall.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/mall/mail")
public class MailController {

    @Resource
    MailService mailService;
    @Resource
    UserService userService;

    @RequestMapping(value = "/loginByEmail", method = RequestMethod.POST)
    public JsonResult getCheckCode(@RequestBody User user){
        String password = UUIDUtil.generateShortUuid();
        try {
            User u = userService.getUserByEmail(user.getEmail());
            if(EmptyUtil.isEmpty(u)){
                return JsonResult.FAILED("用户不存在");
            }
            mailService.sendSimpleMail(user.getEmail(), "Mall系统登录新密码", password,u);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.FAILED("发送失败，请重试!");
        }
        return JsonResult.OK("success");
    }

    @PostMapping(value = "/modifyAvatar")
    public JsonResult modifyAvatar(@RequestBody User user){
        if(user == null || "".equals(user.getAvatar()) || user.getId() == null){
            return JsonResult.FAILED("修改头像失败！");
        }
        User rtnUser = userService.modifyAvatar(user);
        return JsonResult.OK(rtnUser);
    }
}
