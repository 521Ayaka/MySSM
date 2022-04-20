package com.ganga.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class RunMain {

    public static void main(String[] args) {
        //目标对象
        Target target = new Target();
        //增强对象
        MyAdvice myAdvice = new MyAdvice();

        //创建 增强器 对象
        Enhancer enhancer = new Enhancer();
        //指定增强器 要代理的目标类(代理类的父类) 的字节码类型
        enhancer.setSuperclass(target.getClass());
        //设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //前置增强
                myAdvice.before();
                //目标方法
                Object invoke = method.invoke(target, args);
                //后置增强
                myAdvice.after();

                return invoke;
            }
        });

        //获取代理对象
        Target proxy = (Target) enhancer.create();

        //执行代理方法
        proxy.sell();


    }

}
