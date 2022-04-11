package com.ganga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//第三步: 创建Controller类 和 视图页面
//第四步: 使用注解@Controller 将类 添加到容器当中
@Controller
public class UserController {

    //第四步: 使用注解@RequestMapping 添加请求映射
    @RequestMapping("/method")
    public String method(){
        System.out.println("UserController method run ...");
        return "quick.jsp";
    }

}
