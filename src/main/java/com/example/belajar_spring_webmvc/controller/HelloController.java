package com.example.belajar_spring_webmvc.controller;


import com.example.belajar_spring_webmvc.service.HelloService;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;


    @GetMapping("/hello")
    public void helloWorld(@RequestParam(name = "name", required = false) String name, HttpServletResponse response) throws Exception {
        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }

    @GetMapping("/web/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false) String name) {
        if(Objects.isNull(name)){
            return new ModelAndView("redirect:/web/hello?name=Guest");
        }
        return new ModelAndView("hello", Map.of(
                "title", "Hello View",
                "name", name
        ));
    }
}

