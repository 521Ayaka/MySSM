package com.ganga.handler;

import com.ganga.aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserInvocationHandler implements InvocationHandler {

    //创建目标类对象
    Object target;


    /**
     *封装成一个工厂方法 直接获取代理对象的方法
     * @param target
     * @return 返回一个代理对象Proxy.newProxyInstance()
     */
    public Object getInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
        //this: 字节就是那个实现好的 InvocationHandler
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ageObj;

        //增强方法
        MyAspect myAspect = new MyAspect();
        myAspect.check_permission();

        //目标方法
        ageObj = method.invoke(target, args);

        //增强方法
        if (ageObj != null){
            int age = (int) ageObj;
            age = age + 1;
            ageObj = age;
        }
        myAspect.log();

        //返回目标方法的结果
        return ageObj;
    }
}
