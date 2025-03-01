package com.example.belajar_spring_webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
 class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(post("/form/person")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Yossia")
                .param("birthDate", "2025-02-02")  // Ensure format is correct
                .param("address", "Indonesia")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString(
                        "Success create person with name : Yossia, birth date : 2025-02-02, address : Indonesia"
                ))
        );
    }



    @Test
    void formHello() throws Exception {
        mockMvc.perform(post("/form/hello").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("name", "John")).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello John")),
                header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE))
        );
    }
}
