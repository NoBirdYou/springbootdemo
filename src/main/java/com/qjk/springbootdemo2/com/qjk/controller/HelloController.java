package com.qjk.springbootdemo2.com.qjk.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("getName")
    public String hello(ModelMap modelMap){
        modelMap.addAttribute("name","jack");
        return "/template/hello";
    }

}
