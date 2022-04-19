package com.ganga.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyInvocationHandler implements InvocationHandler {

    //定义目标对象
    private Object target;

    //构造方法创建时 传入目标对象
    public MyInvocationHandler(Object target){
        this.target = target;
    }


    /**
     *
     * @param proxy 目标对象 这里不需要设置和调用 也不需要调用
     * @param method 目标方法 method.invoke(定义的目标对象)
     * @param args 目标方法参数 method.invoke(定义的目标对象 , args)
     * @return  和目标方法返回值相同 代理返回
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object money = null;

        //调用目标方法 传入参数
        money = method.invoke(target, args);


        //增强方法
        System.out.println("==========增强方法===========");
        System.out.println("原工厂单个价钱为: " + money);
        if (money != null){
            //增强方法逻辑
            float moneyNew = (float) money;
            moneyNew = moneyNew +25;
            money = moneyNew;
        }
        System.out.println("获取优惠卷.......");
        System.out.println("代理出售单个价钱为:" + money);
        System.out.println("============================");

        //目标对象方法返回什么 代理之后返回什么类型
        return money;
    }
}
