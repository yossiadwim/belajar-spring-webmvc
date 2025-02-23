package com.example.belajar_spring_webmvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void helloGuest() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class);
        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello Guest", Objects.requireNonNull(response.getBody()).trim());
    }


    @Test
    void helloName() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/hello?name=John", String.class);
        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello John", Objects.requireNonNull(response.getBody()).trim());
    }
}
