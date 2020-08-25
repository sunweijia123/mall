package com.wuhan.mall.controller;


import com.wuhan.mall.dao.UserMapper;
import com.wuhan.mall.entity.User;
import com.wuhan.mall.service.MailService;
import com.wuhan.mall.util.EmptyUtil;
import com.wuhan.mall.util.UUIDUtil;
import com.wuhan.mall.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/mall/mail")
public class MailController {

    @Resource
    private MailService mailService;
    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/loginByEmail", method = RequestMethod.POST)
    public JsonResult getCheckCode(@RequestBody User user){
        String password = UUIDUtil.generateShortUuid();
        try {
            User u = userMapper.getUserByEmail(user.getEmail());
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
}
