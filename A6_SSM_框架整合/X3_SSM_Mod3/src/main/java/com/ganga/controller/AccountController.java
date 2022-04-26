package com.ganga.controller;

import com.ganga.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    //http://localhost:8080/X3_SSM_Mod3_war/account/transfer
    @RequestMapping(value = "/transfer",produces = "text/html;charset=utf8")
    @ResponseBody
    public String transfer(){
        accountService.transfer("ganga","gangajiang",1);
        return "成功。。。";
    }

}
