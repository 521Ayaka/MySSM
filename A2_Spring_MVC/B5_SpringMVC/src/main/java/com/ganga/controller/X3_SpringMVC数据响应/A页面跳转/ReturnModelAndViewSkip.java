package com.ganga.controller.X3_SpringMVC数据响应.A页面跳转;

/*
* 返回一个 ModelAndView对象 进行跳转视图
*
*   Model数据模型
*       addObject(key,obj)
*   View 视图页面
*       setViewName(url)
*
* */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/x3")
public class ReturnModelAndViewSkip {

    @RequestMapping("/dame06-1")
    public ModelAndView method01(){
        //创建ModelAndView模型
        ModelAndView modelAndView = new ModelAndView();
        //设置Model数据模型
        modelAndView.addObject("modelKey","123");
        //设置View视图页面
        modelAndView.setViewName("dame06");
        //返回此模型视图对象
        return modelAndView;
    }
    /*
    * 在这个视图文件中 用el表达式可以获取模型数据
    * */


    /**
     * Spring可以提供注入 把参数设置为注入的对象
     * @return
     */
    @RequestMapping("/dame06-2")
    public ModelAndView method02(ModelAndView modelAndView){
        /* 这里的modelAndView 是由Spring容器自动提供注入的 特性 */
        //设置Model数据模型
        modelAndView.addObject("modelKey","321");
        //设置View视图页面
        modelAndView.setViewName("dame06");
        //返回此模型视图对象
        return modelAndView;
    }

}
