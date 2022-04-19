package com.ganga.service;

public class UserTarget {

    /**
     * 目标方法
     * @param name
     * @param age
     * @return
     */
    public int getAge(String name,int age){
        System.out.println("目标方法执行......");
        System.out.println("目标方法执行age参数值为: " + age);
        return age;
    }

}
