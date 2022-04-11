package com.ganga.controller.X1_RequestMapping注解;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/x1")
public class UserControllerDame04 {

    //params = 字符数组   必须携带该字符数组中的所有参数

    @RequestMapping(value = "/dame04-1",params = {"username","id"},method = RequestMethod.GET)
    public String method1(){
        System.out.println("run UserControllerDame04-1 dame04-1 ...");
        return "/jsp/dame04-1.jsp";
    }

    /*
    *   http://localhost:8080/B5_SpringMVC_war/web/x1/dame04
    *   不可以访问
    *
    *   http://localhost:8080/B5_SpringMVC_war/web/x1/dame04?username=xxx
    *   不可以访问
    *
    *   http://localhost:8080/B5_SpringMVC_war/web/x1/dame04?username=xxx&id=xxx
    *   可以访问
    *
    *   必须要带 字符数组中的所有参数
    *
    * */


    //params = {"user!100"} user参数不能说100
    @RequestMapping(value = "/dame04-2",params = {"user!100"},method = RequestMethod.GET)
    public String method2(){
        System.out.println("run UserControllerDame04-2 dame04-2 ...");
        return "/jsp/dame04-2.jsp";
    }



}
