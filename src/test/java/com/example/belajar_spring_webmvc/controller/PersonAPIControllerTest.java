package com.example.belajar_spring_webmvc.controller;

import com.example.belajar_spring_webmvc.model.CreatePersonRequest;
import com.example.belajar_spring_webmvc.model.CreateSocialMediaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception {

        CreatePersonRequest request= new CreatePersonRequest();
        request.setFirstName("Yossia");
        request.setMiddleName("Dwi");
        request.setLastName("Mahardika");
        request.setEmail("yossia@example.com");
        request.setPhone("08123456789");
        request.setHobbies(List.of("Coding", "Reading", "Sleeping"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("Instagram", "instagram.com/yossia.dwi"));

        String requestJson = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpectAll(
                    status().isOk(),
                        content().json(requestJson)
                );


    }

    @Test
    void createPersonNotValidationError() throws Exception {

        CreatePersonRequest request= new CreatePersonRequest();
        request.setMiddleName("Dwi");
        request.setLastName("Mahardika");
        request.setHobbies(List.of("Coding", "Reading", "Sleeping"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("Instagram", "instagram.com/yossia.dwi"));

        String requestJson = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpectAll(
                    status().isBadRequest(),
                        content().string(Matchers.containsString("Validation Error"))

                );


    }


}