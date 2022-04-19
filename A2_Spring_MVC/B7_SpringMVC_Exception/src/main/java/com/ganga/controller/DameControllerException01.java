package com.ganga.controller;

import com.ganga.exception.MyException;
import com.ganga.service.DameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;

@Controller
@RequestMapping("/web/x1")
public class DameControllerException01 {

    @Autowired
    private DameService dameService;

    @RequestMapping("/show1")
    public ModelAndView show1(ModelAndView modelAndView){
        dameService.show1();
        modelAndView.addObject("param","gangajiang");
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }

    @RequestMapping("/show2")
    public ModelAndView show2(ModelAndView modelAndView){
        dameService.show2();
        modelAndView.addObject("param","gangajiang");
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }

    @RequestMapping("/show3")
    public ModelAndView show3(ModelAndView modelAndView) throws FileNotFoundException {
        dameService.show3();
        modelAndView.addObject("param","gangajiang");
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }

    @RequestMapping("/show4")
    public ModelAndView show4(ModelAndView modelAndView){
        dameService.show4();
        modelAndView.addObject("param","gangajiang");
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }

    @RequestMapping("/show5")
    public ModelAndView show5(ModelAndView modelAndView) throws MyException {

        dameService.show5();
        modelAndView.addObject("param","gangajiang");
        modelAndView.setViewName("/index.jsp");
        return modelAndView;

    }

}
