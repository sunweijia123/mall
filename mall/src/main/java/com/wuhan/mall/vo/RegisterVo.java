package com.wuhan.mall.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterVo {

    @NotBlank(message = "姓名不能为空")
    private String name;

    private String avatar;

    @NotBlank(message = "邮箱不能为空")
    private String email;

    @NotBlank(message = "账户不能为空")
    private String loginAccont;

    @NotBlank(message = "密码不能为空")
    private String password;
}
