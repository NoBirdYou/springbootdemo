package com.qjk.springbootdemo2.com.qjk.controller;

import com.qjk.springbootdemo2.com.qjk.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/th")
public class ThymeleafController {

    @RequestMapping("index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("name","rose");
        return "/thymeleaf/index";
    }

    @RequestMapping("test")
    public String test(ModelMap modelMap){
        User user=new User();
        user.setName("manager");
        user.setAge(24);
        user.setBirthday(new Date());
        user.setDesc("<font color='green'><b>hello imooc</b></font>");

        List<User> userList=new ArrayList<>();

        User user1=new User();
        user1.setName("rose");
        user1.setAge(18);
        user1.setBirthday(new Date());
        user1.setDesc("hello");

        User user2=new User();
        user2.setName("oop");
        user2.setAge(22);
        user2.setBirthday(new Date());
        user2.setDesc("world");

        userList.add(user1);
        userList.add(user2);

        modelMap.addAttribute("user",user);
        modelMap.addAttribute("userList",userList);
        return "/thymeleaf/test";
    }

    @RequestMapping("postform")
    public String postform(User user){
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getBirthday());
        System.out.println(user.getDesc());
        return "redirect:/th/test";
    }
}
