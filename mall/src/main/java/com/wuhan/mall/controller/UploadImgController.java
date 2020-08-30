package com.wuhan.mall.controller;

import com.wuhan.mall.util.UUIDUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/images/")
public class UploadImgController {

    @PostMapping(value = "/upload")
    public String upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        List<String> extList = Arrays.asList(".jpg", ".png", ".jpeg", ".gif");
        if (!extList.contains(suffixName)) {
            return "图片格式非法";
        }
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName =  UUIDUtil.generateShortUuid() + suffixName;
        // 返回客户端 文件地址 URL
        String url = "http://118.178.254.125:8081/upload/" + fileName;
        File dest = new File( "/usr/java/images/" + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        return url;
    }
}
