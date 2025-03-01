package com.example.belajar_spring_webmvc.controller;


import com.example.belajar_spring_webmvc.model.HelloRequest;
import com.example.belajar_spring_webmvc.model.HelloResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BodyController {

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(

            path = "/body/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    String body(
            @RequestBody String requestBody
    ) throws JsonProcessingException {
        HelloRequest request = objectMapper.readValue(requestBody, HelloRequest.class);
        HelloResponse response = new HelloResponse();
        response.setHello("Hello " + request.getName());

        return objectMapper.writeValueAsString(response);
    }
}
