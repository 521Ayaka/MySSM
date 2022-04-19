package com.ganga.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mav = new ModelAndView();
        //判断异常 并写入相应的逻辑
        if (ex instanceof ClassCastException){
            mav.addObject("errors","类转换异常");
        }else if (ex instanceof ArithmeticException){
            mav.addObject("errors","除0异常");
        }else if (ex instanceof FileNotFoundException){
            mav.addObject("errors","空文件路径异常");
        }else if (ex instanceof NullPointerException){
            mav.addObject("errors","空指针异常");
        }else if (ex instanceof MyException){
            mav.addObject("errors","自定义异常");
        }//这里只是演示而已 一般里面写的是相应的逻辑！

        mav.setViewName("/errors.jsp");

        return mav;
    }
}
