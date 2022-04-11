package com.ganga.controller.X1_RequestMapping注解;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class UserControllerDame01 {

    @RequestMapping("/dame01")
    public String dame01() {
        System.out.println("run UserControllerDame01 dame01 ...");
        return "jsp/dame01.jsp";
    }

}
