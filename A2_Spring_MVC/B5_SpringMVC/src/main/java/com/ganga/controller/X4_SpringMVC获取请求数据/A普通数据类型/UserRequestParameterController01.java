package com.ganga.controller.X4_SpringMVC获取请求数据.A普通数据类型;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/x4")
public class UserRequestParameterController01 {

    @RequestMapping("/user01")
    @ResponseBody
    public String user01(String username, int age) {
        System.out.println(username + " : " + age);
        String write = "<h1 align=\"center\">getParameter: username=" + username +
                "  &  age=" + age + "</h1>";
        return write;
    }

    /*
    * 接收普通数据类型方法
    *   将方法的参数设置成为 要获取提交参数的类型 名称要一样
    *
    *   http://localhost:8080/B5_SpringMVC_war/web/x4/user01?username=ganga&age=9
    *
    *   user01(String username, int age){//...}
    *
    * */

}
