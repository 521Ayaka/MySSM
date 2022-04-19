package com.ganga.aspect;

//这是一个切面
public class MyAspect {

    public void check_permission(){
        System.out.println("检查权限...");
    }

    public void log(){
        System.out.println("日志记录...");
    }

}
