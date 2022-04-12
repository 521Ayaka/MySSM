package com.ganga.controller.X4_SpringMVC获取请求数据.D集合数据类型;

import com.ganga.pojo.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/x4")
public class UserRequestParameterController04 {

    @RequestMapping("/user04")
    @ResponseBody
    public String user04(VO vo){
        System.out.println(vo.toString());
        return vo.toString();
    }

}
