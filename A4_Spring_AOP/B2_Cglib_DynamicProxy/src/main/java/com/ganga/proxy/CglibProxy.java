package com.ganga.proxy;

import com.ganga.aspect.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    //目标对象
    Object target;

    /**
     * 创建代理对象的方法
     * @param target 调用时传入相应的目标对象
     * @return
     */
    public Object createProxy(Object target){
        //转入目标对象
        this.target = target;

        //创建Enhancer核心增强代码
        Enhancer enhancer = new Enhancer();
        //设置被代理的对象的类型
        enhancer.setSuperclass(target.getClass());
        //设置如何增强 参数需要一个MethodInterceptor 此类即是
        enhancer.setCallback(this);
        //获取动态代理对象
        Object proxy = enhancer.create();
        return proxy;

    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //实现增强方法  调用目标前
        MyAspect myAspect = new MyAspect();
        myAspect.check_permission();

        //实现调用目标方法 --反射
        //方式一: 使用原目标对象调用目标方法
        Object ageObj = null;
        ageObj = method.invoke(target, args);
        //方式二: 使用代理对象调用目标方法
        //Object age = methodProxy.invokeSuper(proxy, args);

        //实现增强方法  调用方法后
        if (ageObj != null){
            int age = (int) ageObj;
            age = age + 1;
            ageObj = age;
        }
        myAspect.log();

        //返回代理方法返回结果 可也是增强后的方法
        return ageObj;
    }
}
