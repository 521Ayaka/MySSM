package com.ganga.controller.X3_SpringMVC数据响应.B回写数据;

import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/web/x3")
public class WriterBackAttributeObjAndList {

    /*
    * 回写数据
    *   返回值是个对象 WriterBackAttribute 的me05演示过了
    * */
    @RequestMapping("/dame09-1")
    @ResponseBody
    public User me01() {
        //模拟一个对象
        User user = new User("obg-me01", 99);
        return user;
    }

    /*
    * 返回一个集合
    *
    *
    * */

    @RequestMapping("/dame09-2")
    @ResponseBody
    public List<User> me02() {
        //模拟一个对象集合
        List<User> users = new ArrayList<User>();
        users.add(new User("lisa", 17));
        users.add(new User("zs", 99));
        users.add(new User("ls", 66));
        return users;
    }

}
