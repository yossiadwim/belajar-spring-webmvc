package com.example.belajar_spring_webmvc.controller;

import com.example.belajar_spring_webmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserController {

    @GetMapping("/user/current")
    @ResponseBody
    public String getUser(@SessionAttribute("username") User user){
        return "Hello " + user.getUsername();

    }
}

