package com.ganga.controller;

import com.ganga.pojo.User;
import com.ganga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add",produces = "text/html;charset=utf8")
    @ResponseBody
    public String addUser(@RequestParam("user") String username) {
        int i = userService.addUser(username);
        if (i == 0){
            return "<h1 alert=\"center\">添加失败...</h1>";
        }else {
            return "<h1 alert=\"center\">添加成功...</h1>";

        }
    }


    @RequestMapping("/select")
    @ResponseBody
    public String userAll() {
        List<User> users = userService.userAll();
        return users.toString();
    }

}
