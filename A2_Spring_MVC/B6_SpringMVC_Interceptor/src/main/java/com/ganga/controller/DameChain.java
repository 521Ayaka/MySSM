package com.ganga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("web/dame03")
public class DameChain {

    @RequestMapping("/chain")
    public ModelAndView me(ModelAndView modelAndView){
        //http://localhost:8080/B6_SpringMVC_Interceptor_war/web/dame03/chain
        modelAndView.addObject("params","chain");
        modelAndView.setViewName("/index.jsp");
        System.out.println("\n 访问执行...");
        return modelAndView;
    }

}
