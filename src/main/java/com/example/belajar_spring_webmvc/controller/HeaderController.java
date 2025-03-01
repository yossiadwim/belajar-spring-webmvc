package com.example.belajar_spring_webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping("/header/token")
    @ResponseBody
    public String header(@RequestHeader(name = "X-TOKEN") String token){
        if("YOSSIA".equals(token)){
            return "OK";
        }
        else{
            return "NOT OK";
        }
    }
}
