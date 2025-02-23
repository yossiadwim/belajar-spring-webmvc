package com.example.belajar_spring_webmvc.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        if (name == null) {
            name = "Guest";
        }
        return "Hello " + name;
    }
}
