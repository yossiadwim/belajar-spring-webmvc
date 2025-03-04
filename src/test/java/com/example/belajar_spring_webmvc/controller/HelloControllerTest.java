package com.example.belajar_spring_webmvc.controller;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloGuest() throws Exception {
        mockMvc.perform(get("/hello")).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Guest")));
    }

    @Test
    void helloName() throws Exception {
        mockMvc.perform(get("/hello").param("name", "John")).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello John")));
    }

    @Test
    void testHelloPost() throws Exception {
        mockMvc.perform(post("/hello").param("name", "John")).andExpectAll(status().isMethodNotAllowed());
    }

    @Test
    void helloView() throws Exception {

        mockMvc.perform(
                get("/web/hello").queryParam("name", "John")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello John"))
        );
    }

    @Test
    void helloViewRedirect() throws Exception {
        mockMvc.perform(get("/web/hello")).andExpectAll(status().is3xxRedirection());
    }
}
