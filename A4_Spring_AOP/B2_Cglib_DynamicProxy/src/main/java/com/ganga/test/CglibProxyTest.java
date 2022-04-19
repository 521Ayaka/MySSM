package com.ganga.test;

import com.ganga.proxy.CglibProxy;
import com.ganga.service.UserTarget;

public class CglibProxyTest {

    public static void main(String[] args) {

        //创建代理对象
        UserTarget userTarget = new UserTarget();
        //创建代理工厂对象
        CglibProxy im = new CglibProxy();
        //调用工厂对象对象 获取动态代理
        UserTarget proxy = (UserTarget) im.createProxy(userTarget);
        //代理后
        int age = proxy.getAge("尴尬酱", 9);

        System.out.println("代理后age的值是: " + age);

    }

/*

检查权限...
目标方法执行......
目标方法执行age参数值为: 9
日志记录...
代理后age的值是: 10

*/
}
