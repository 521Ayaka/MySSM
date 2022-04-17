package com.ganga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/dame02")
public class DameController02 {

    @RequestMapping("/me02")
    public ModelAndView method02(ModelAndView modelAndView,@RequestParam("user") String username){
        //http://localhost:8080/B6_SpringMVC_Interceptor_war/web/dame02/me02        不可以访问
        //http://localhost:8080/B6_SpringMVC_Interceptor_war/web/dame02/me02?user=gangajiang 不可以访问
        //http://localhost:8080/B6_SpringMVC_Interceptor_war/web/dame02/me02?user=ganga 可以访问
        modelAndView.addObject("params",username);
        modelAndView.setViewName("/index.jsp");
        System.out.println("\n访问执行...");
        return modelAndView;
    }

}
