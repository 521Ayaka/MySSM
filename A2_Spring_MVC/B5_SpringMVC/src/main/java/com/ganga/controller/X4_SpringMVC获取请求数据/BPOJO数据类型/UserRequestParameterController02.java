package com.ganga.controller.X4_SpringMVC获取请求数据.BPOJO数据类型;

import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/x4")
public class UserRequestParameterController02 {

    @RequestMapping("/user02")
    @ResponseBody
    public String user02(User user){
        System.out.println(user);
        String write = "<h1 align=\"center\">getParameter: " +user.toString() + "</h1>";
        return write;
    }

    /*
    * User实体类中的属性
    *    请求参数必须是实体类中的 成员变量(且有set方法)
    *    请求参数 ∈ 成员变量(且有set方法)
    *
    * SpringMVC会自动封装 为一个实体类的对象
    *
    * */

}
