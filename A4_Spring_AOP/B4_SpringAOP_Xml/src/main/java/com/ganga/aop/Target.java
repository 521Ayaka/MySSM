package com.ganga.aop;

public class Target implements TargetInterface {
    @Override
    public void sell1() {
        System.out.println("目标方法执行。。。");
    }

    @Override
    public int sell2(String name,int age) {
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        return age;
    }

    @Override
    public int sell3(String name, int age){
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        int i = 1/0; //异常
        return age;
    }
}
