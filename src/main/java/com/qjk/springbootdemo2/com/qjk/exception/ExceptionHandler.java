package com.qjk.springbootdemo2.com.qjk.exception;


import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常拦截，只拦截controller层异常
 */
//@ControllerAdvice
public class ExceptionHandler {

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ModelAndView errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e){
        e.printStackTrace();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
