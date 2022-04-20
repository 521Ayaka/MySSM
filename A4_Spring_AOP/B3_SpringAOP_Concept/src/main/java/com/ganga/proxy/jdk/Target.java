package com.ganga.proxy.jdk;

public class Target implements TargetInterface{
    @Override
    public void sell() {
        System.out.println("目标方法执行。。。");
    }
}
