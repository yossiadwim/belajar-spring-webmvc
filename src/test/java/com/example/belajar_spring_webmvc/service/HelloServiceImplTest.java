package com.example.belajar_spring_webmvc.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceImplTest {

    @Autowired
    private HelloService helloService;

    @Test
    void testHello() {
        Assertions.assertEquals("Hello Guest", helloService.hello(null));
        Assertions.assertEquals("Hello John", helloService.hello("John"));
    }
}
