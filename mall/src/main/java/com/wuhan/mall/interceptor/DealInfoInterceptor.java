package com.wuhan.mall.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class DealInfoInterceptor implements HandlerInterceptor {
   final static List<String> list = new ArrayList<>();
    static {
        list.add("/mall/dealInfo/addDealInfo");
        list.add("/mall/dealInfo/updateDealInfo");
        list.add("/mall/dealInfo/getDealInfoList");
    }
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //TODO header里面把userId的信息传过来，这里做限制
        String uri = httpServletRequest.getRequestURI();
        if(list.contains(uri)){
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}


