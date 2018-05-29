package com.qjk.springbootdemo2.com.qjk.exception;

import com.qjk.springbootdemo2.com.qjk.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class AjaxExceptionHandler {

//    @ExceptionHandler(Exception.class)
    public IMoocJSONResult errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e){
        e.printStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Object errorHandlerAjaxOrWeb(HttpServletRequest request,HttpServletResponse response,Exception e){

        e.printStackTrace();

        if(isAjax(request)){
            return IMoocJSONResult.errorException(e.getMessage());
        }else{
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("exception",e);
            modelAndView.addObject("url",request.getRequestURL());
            modelAndView.setViewName("error");
            return modelAndView;
        }

    }

    /**
     * 判断是否是Ajax请求
     * @param httpRequest
     * @return
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}
