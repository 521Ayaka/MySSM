package com.ganga.controller;

import com.ganga.service.TransferService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* 这里只是模拟web服务端
* */
public class TransferController {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        TransferService transfer = app.getBean(TransferService.class);

        transfer.transfer("ganga","gangajiang",1);


    }
    
}
