package com.qjk.springbootdemo2.com.qjk.controller;

import com.qjk.springbootdemo2.com.qjk.pojo.IMoocJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("error")
public class ErrorController {

    @RequestMapping("showError")
    public String showError(){
        int i=1/0;
        return "thymeleaf/error";
    }

    @RequestMapping("ajaxError")
    public String ajaxError(){
        return "ajaxError";
    }

    @RequestMapping("getAjaxError")
    @ResponseBody
    public IMoocJSONResult getAjaxError(){
        int i=1/0;
        return IMoocJSONResult.ok();
    }
}
