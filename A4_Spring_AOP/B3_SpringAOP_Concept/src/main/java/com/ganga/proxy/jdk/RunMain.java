package com.ganga.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RunMain {

    public static void main(String[] args) {
        //目标对象
        Target target = new Target();
        //增强对象
        MyAdvice myAdvice = new MyAdvice();
        //代理对象  返回类型 用 目标接口接收！
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAdvice.before(); //前置增强
                        Object invoke = method.invoke(target, args);//目标方法
                        myAdvice.after(); //后置增强
                        return invoke;
                    }
                }
        );

        //执行代理对象 的 目标方法
        proxy.sell();

    }

}
