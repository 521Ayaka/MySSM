package com.ganga.controller.X1_RequestMapping注解;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*
这里加了@RequestMapping("/web/x1")注解
    该类里的方法 是"/web/x1"的子项目
*/
@RequestMapping("/web/x1")
public class UserControllerDame02 {
    /*
    * 实际地址:http://localhost:8080/B5_SpringMVC_war/web/x1/dame02
    * */
    @RequestMapping("/dame02")
    public String method(){
        System.out.println("run UserControllerDame02 dame02 ...");
        return "/jsp/dame02.jsp";
        /*
        * 返回字符串前不加 "/"
        *   访问的资源是: http://localhost:8080/B5_SpringMVC_war/web/x1/jsp/dame02.jsp
        *
        * 返回字符串前加上 "/"
        *   访问的资源是: http://localhost:8080/B5_SpringMVC_war/jsp/dame02.jsp
        *
        * [注意!] [所以] 要访问根对应的文件 一定要加上"/"
        *
        * */
    }

}
