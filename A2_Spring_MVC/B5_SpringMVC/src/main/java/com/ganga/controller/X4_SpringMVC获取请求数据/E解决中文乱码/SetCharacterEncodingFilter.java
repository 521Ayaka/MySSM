package com.ganga.controller.X4_SpringMVC获取请求数据.E解决中文乱码;

import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/x4")
public class SetCharacterEncodingFilter {

    @RequestMapping("/setEncoding")
    @ResponseBody
    public User setEncoding(User user){
        return user;
    }

}
