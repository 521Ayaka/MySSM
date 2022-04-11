package com.ganga.controller.X1_RequestMapping注解;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//1. 不设置路径

@Controller()
@RequestMapping("web/x1")
public class UserControllerDame03 {

    //value = "" 服务资源路径 value可以省略
    //method = 特定的请求方式 [必须是枚举类型] [ RequestMethod.GET ] [ RequestMethod.POST ]等

    //get请求
    @RequestMapping(value = "/dame03-1",method = RequestMethod.GET)
    public String dame01() {
        System.out.println("run UserControllerDame03 dame03 ...");
        return "/jsp/dame03.jsp";
    }//访问成功

    //post请求
    @RequestMapping(value = "/dame03-2",method = RequestMethod.POST)
    public String dame02() {
        System.out.println("run UserControllerDame03 dame031 ...");
        return "/jsp/dame03.jsp";
    }//访问失败 因为这里用的是get请求 访问不了/web/x1/dame03-2

}
