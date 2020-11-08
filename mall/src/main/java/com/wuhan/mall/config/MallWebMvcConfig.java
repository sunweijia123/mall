package com.wuhan.mall.config;

import com.wuhan.mall.interceptor.DealInfoInterceptor;
import com.wuhan.mall.interceptor.ProcessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MallWebMvcConfig implements WebMvcConfigurer {

    @Resource
    ProcessInterceptor interceptor;
    @Resource
    DealInfoInterceptor dealInfoInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns("/");
//        registry.addInterceptor(dealInfoInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/usr/java/images/");
    }

}
