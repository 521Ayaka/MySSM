package com.ganga.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
* 创建一个实现类 实现 HandlerInterceptor接口
*
*   实现/覆盖重写 preHandle()
*               postHandle()
*               afterCompletion()
*               三个方法
*
* */
public class MyInterceptor01 implements HandlerInterceptor {

    /**
     * 在访问目标执行之前执行
     * @param request
     * @param response
     * @param handler
     * @return 返回值是一个boolean值 true:允许访问 false:不能访问
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("\n run preHandle ...");
        return true; //true： true:允许访问 false:不能访问
    }

    //在访问目标执行之后 返回视图/视图模型之前 执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("\n run postHandle ...");
    }

    //在目标访问执行完毕后 返回视图/视图模型之后 执行收尾之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("\n run afterCompletion ...");
    }
}
