package com.ganga.controller.X3_SpringMVC数据响应.A页面跳转;

/*
* 返回字符串
*
* 配置ViewResolver视图解析器后
*   不需要写前缀 和 后缀
*
* */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/x3")
public class ReturnStringSkip {

    @RequestMapping("/dame05-1")
    public String method01(){
        System.out.println("run dame05 method01");
        return "dame05";
    }
    /*
    *   <!-- 配置视图解析器 ViewResolver -->
    *   <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    *       <!-- 配置前缀 -->
    *       <property name="prefix" value="/jsp/"/>
    *       <!-- 配置后缀 -->
    *       <property name="suffix" value=".jsp"/>
    *   </bean>
    *
    *   /jsp/ + dame05 + .jsp
    *   = /jsp/dame05.jsp
    * */


    /*
    * 源码:
    *   public static final String REDIRECT_URL_PREFIX = "redirect:";
    *   public static final String FORWARD_URL_PREFIX = "forward:";
    *
    * 不加: 默认forward: 转发
    *          redirect: 重定向
    * */
    //
    @RequestMapping("dame05-2")
    public String method02(){
        System.out.println("run dame05 method02");
        return "redirect:http://localhost:8080/B5_SpringMVC_war/jsp/dame05.jsp";
    }
    //重定向 绝对路径



}
