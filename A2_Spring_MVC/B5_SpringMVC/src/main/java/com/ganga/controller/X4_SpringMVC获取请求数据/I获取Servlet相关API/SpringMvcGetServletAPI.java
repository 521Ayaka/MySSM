package com.ganga.controller.X4_SpringMVC获取请求数据.I获取Servlet相关API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
方法参数类型是Servlet相关API SpringMVC回自动注入
    HttpServletResponse
    HttpServletResponse
    HttpSession
* */
@Controller
@RequestMapping("/web/x4")
public class SpringMvcGetServletAPI {

    //http://localhost:8080/B5_SpringMVC_war/web/x4/getAPI
    @RequestMapping("/getAPI")
    @ResponseBody
    public String getServletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return request + "<br>" + response + "<br>" + session;
    }

}
