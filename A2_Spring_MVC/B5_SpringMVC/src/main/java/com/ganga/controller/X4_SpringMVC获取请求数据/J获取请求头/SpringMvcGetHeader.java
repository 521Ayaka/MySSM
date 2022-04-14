package com.ganga.controller.X4_SpringMVC获取请求数据.J获取请求头;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 获取请求头参数
*
* */
@Controller
@RequestMapping("/web/x4")
public class SpringMvcGetHeader {


    /*
    * 注解: @RequestHeader
    *   value指定获取的请求头
    * */
    @RequestMapping("/getHeader")
    @ResponseBody
    public String getHeader(@RequestHeader("User-Agent") String user_agent){
        //http://localhost:8080/B5_SpringMVC_war/web/x4/getHeader
        System.out.println(user_agent);
        return user_agent;
    }

    /*
    * 快速获取请求头参数 Cookie 参数键对应的的值
    * 注解: @CookieValue
    *   直接获取请求体
    *   value cookie的键
    *
    * */
    @RequestMapping("/getCookie")
    @ResponseBody
    public String getCookie(@CookieValue("JSESSIONID") String JSESSIONID){
        //http://localhost:8080/B5_SpringMVC_war/web/x4/getCookie
        System.out.println(JSESSIONID);
        return JSESSIONID;
    }


}
