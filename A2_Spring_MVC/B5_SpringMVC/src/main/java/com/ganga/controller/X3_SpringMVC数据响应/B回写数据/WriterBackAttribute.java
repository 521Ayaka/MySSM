package com.ganga.controller.X3_SpringMVC数据响应.B回写数据;

import com.alibaba.fastjson.JSON;
import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/web/x3")
public class WriterBackAttribute {

    /*
    * 回写数据
    * */

    //过SpringMVC框架注入的response对象
    @RequestMapping("/dame08-1")
    public void me01(HttpServletResponse response) throws IOException {
        response.getWriter().print("response! me01");
    }

    //使用@ResponseBody注解
    //注解告知SpringMVC框架，方法
    //返回的字符串不是跳转是直接在http响应体中返回。
    @RequestMapping("/dame08-2")
    @ResponseBody
    public String me02(){
        /*没有参数 返回的字符串不是跳转的页面 而是回写的内容*/
        return "response! me02";
    }

    //手动回写JSON数据
    @RequestMapping("/dame08-3")
    @ResponseBody
    public String me03(){
        //手动书写JSON {"username":"ganga","age":18}
        return "{\"username\":\"ganga\",\"age\":18}";
    }

    //使用外部JSON转换工具
    @RequestMapping("/dame08-4")
    @ResponseBody
    public String me04(){
        //模拟一个对象
        User user = new User("gangajiang", 9);
        //使用json转换工具进行转换
        String json = JSON.toJSONString(user);
        return json;
    } // {"age":9,"username":"gangajiang"}

    /*
    * 上面太麻烦了
    *     SpringMVC提供了相应的机制！
    *
    * */


    //使用外部JSON转换工具
    @RequestMapping("/dame08-5")
    @ResponseBody
    public User me05(){
        System.out.println("run dame08-5 me05...");
        //模拟一个对象
        User user = new User("obg", 99);

        return user;
    }

}
