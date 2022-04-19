package com.ganga.controller;

import com.ganga.exception.MyException;
import com.ganga.service.DameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;

@Controller
@RequestMapping("/web/x2")
public class DameControllerException02 {

    @Autowired
    private DameService dameService;

    @RequestMapping("/show1")
    @ResponseBody
    public void show1(){
        //http://localhost:8080/B7_SpringMVC_Exception_war/web/x2/show1
        dameService.show1();
    }

    @RequestMapping("/show2")
    @ResponseBody
    public void show2(){
        //http://localhost:8080/B7_SpringMVC_Exception_war/web/x2/show2
        dameService.show2();
    }

    @RequestMapping("/show3")
    @ResponseBody
    public void show3() throws FileNotFoundException {
        //http://localhost:8080/B7_SpringMVC_Exception_war/web/x2/show3
        dameService.show3();
    }

    @RequestMapping("/show4")
    @ResponseBody
    public void show4(){
        //http://localhost:8080/B7_SpringMVC_Exception_war/web/x2/show4
        dameService.show4();
    }

    @RequestMapping("/show5")
    @ResponseBody
    public void show5() throws MyException {
        //http://localhost:8080/B7_SpringMVC_Exception_war/web/x2/show5
        dameService.show5();

    }

}