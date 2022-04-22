package com.ganga.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


import org.aspectj.lang.ProceedingJoinPoint;

@Component("myAdvice")
@Aspect //声明该类 是 切面类
public class MyAdvice {

    //抽取 切点表达式
    @Pointcut("execution(* com.ganga.aop..*.sell3(..))")
    public void pointcut(){}

    //前置增强
    @Before("execution(* com.ganga.aop..*.sell3(..))") // 通知 + 切点    before + 切点表达式
    public void before(){
        System.out.println("前置增强...");
    }

    //后置增强
    @AfterReturning("pointcut()") //引用切点表达式 方式一
    public void afterReturning(){
        System.out.println("后置增强...");
    }

    //环绕增强
    @Around("MyAdvice.pointcut()") //引用切点表达式 方式二
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强....");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强....");
        return proceed;
    }

    //抛异常后增强
    @AfterThrowing("execution(* com.ganga.aop..*.sell3(..))")
    public void throwing(){
        System.out.println("异常抛出后增强...");
    }

    //最终增强
    @After("execution(* com.ganga.aop..*.sell3(..))")
    public void after(){
        System.out.println("最终增强....");
    }


}
