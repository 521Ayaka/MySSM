package com.ganga.controller.X4_SpringMVC获取请求数据.F注解RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestParam 注解演示
 */

@Controller
@RequestMapping("/web/x4")
public class TestRequestParamAnnotation {

    @RequestMapping("/param00")
    @ResponseBody
    public String param00(String username){
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param00?username=ganga  请求到参数: ganga
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param00?user=gangale    请求到参数: null
        System.out.println(username);
        if (username == null){
            return "null";
        }
        return username;
    }
    /*
    * 当请求的参数是username可以接收
    *
    * 如果请求的参数是user是 接收失败
    *
    * */

    /*
     * RequestParam有三个参数:
     *
     *   value: 与请求参数相同,映射成方法参数名
     *   required: 此在指定的请求参数是否必须包含, 默认是true, 提交时没有该参数就会报错
     *   defaultValue: 当没有指定这个请求参数时, 则会使用指定的默认值
     *
     * */

    //使用@RequestParam注解进行映射
    @RequestMapping("/param01")
    @ResponseBody
    public String param01(@RequestParam("name") String username){
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param01?username=ganga      请求失败
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param01?name=gangajiang     请求到参数: gangajiang
        System.out.println(username);
        return username;
    }

    @RequestMapping("/param02-1")
    @ResponseBody
    public String param02_1(@RequestParam(value = "name",required = true) String username){
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param02-1?name=ganga    请求成功
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param02-1               请求失败
        System.out.println(username);
        return username;
    }
    @RequestMapping("/param02-2")
    @ResponseBody
    public String param02_2(@RequestParam(value = "name",required = false) String username){
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param02-2?name=ganga    请求成功
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param02-2               请求成功
        System.out.println(username);
        return username;
    }

    @RequestMapping("/param03")
    @ResponseBody
    public String param03(@RequestParam(value = "name",defaultValue = "default") String username){
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param03?name=ganga   请求到参数: ganga
        //http://localhost:8080/B5_SpringMVC_war/web/x4/param03              请求到参数: default
        System.out.println(username);
        return username;
    }


}
