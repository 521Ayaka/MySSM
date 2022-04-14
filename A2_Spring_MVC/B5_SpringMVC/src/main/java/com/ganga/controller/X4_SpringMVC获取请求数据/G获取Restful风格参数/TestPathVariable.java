package com.ganga.controller.X4_SpringMVC获取请求数据.G获取Restful风格参数;

/*
*
* Restful是一种软件架构风格、设计风格，而不是标准，
* 只是提供了一组设计原则和约束条件。
* 主要用于客户端和服务器交互类的软件，
* 基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存机制等。
*
*
* GET:      用于获取资源
* POST:     用于新建资源
* PUT:      用于更新资源
* DELETE:   用于删除资源
* */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/x4")
public class TestPathVariable {

    @RequestMapping("/restful/{user}")
    @ResponseBody
    public String pathVariable(@PathVariable(value = "user",required = false) String username){
        //http://localhost:8080/B5_SpringMVC_war/web/x4/restful/gangajiang
        System.out.println(username);
        return username;
    }

    //restful风格参数   post: 用于新建资源   可以在映射服务时  添加指定方式 method=RequestMethod.POST
    @RequestMapping(value = "/userAdd/{user}",method = RequestMethod.POST)
    @ResponseBody
    public String pathVariablePost(@PathVariable("user") String username){
        System.out.println(username);
        return username;
    }

}
