package com.qjk.springbootdemo2.com.qjk.controller;

import com.qjk.springbootdemo2.com.qjk.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("resource",resource);
        return "freemarker/index";
    }
}
