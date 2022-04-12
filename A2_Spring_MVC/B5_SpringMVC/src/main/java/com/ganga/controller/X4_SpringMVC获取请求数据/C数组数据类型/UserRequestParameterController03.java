package com.ganga.controller.X4_SpringMVC获取请求数据.C数组数据类型;

import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/web/x4")
public class UserRequestParameterController03 {

    @RequestMapping("/user03")
    @ResponseBody
    public String user03(String[] pramName){
        List<String> strings = Arrays.asList(pramName);
        System.out.println(strings);
        return strings.toString();
    }
    //http://localhost:8080/B5_SpringMVC_war/web/x4/user03?pramName=1111111&pramName=2222222

    /*
    * 参数名称是 abc
    *
    *   (String[] abc) 参数字符数组的名字 就是 abc
    * */

}
