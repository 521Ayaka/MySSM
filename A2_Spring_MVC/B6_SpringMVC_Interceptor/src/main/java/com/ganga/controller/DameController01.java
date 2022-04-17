package com.ganga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/dame01")
public class DameController01 {

    @RequestMapping("/me01")
    public ModelAndView method01(ModelAndView modelAndView){
        //http://localhost:8080/B6_SpringMVC_Interceptor_war/web/dame01/me01
        modelAndView.addObject("params","gangajiang");
        modelAndView.setViewName("/index.jsp");
        System.out.println("\n访问执行...");
        return modelAndView;
    }


}
