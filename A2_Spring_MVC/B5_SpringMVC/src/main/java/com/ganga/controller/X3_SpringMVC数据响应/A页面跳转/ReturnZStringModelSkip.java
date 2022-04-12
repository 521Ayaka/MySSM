package com.ganga.controller.X3_SpringMVC数据响应.A页面跳转;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *   ReturnModelAndViewSkip
 *   ReturnStringModelSkip
 *
 *   进行拆分
 * */
@Controller
@RequestMapping("web/x3")
public class ReturnZStringModelSkip {

    @RequestMapping("/dame06-m")
    public String method(Model model){
        //设置模型数据
        model.addAttribute("modelKey","model...");
        //直接跳转页面字符串
        return "dame06";
    }


}
