package com.example.belajar_spring_webmvc.controller;

import jakarta.servlet.http.Cookie;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loginSuccess() throws Exception {

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "Yossia")
                .param("password", "1234")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OK")),
                cookie().value("username", Matchers.containsString("Yossia"))
        );
    }

    @Test
    void loginFailed() throws Exception {

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "Yossia")
                .param("password", "12345")
        ).andExpectAll(
                status().isUnauthorized(),
                content().string(Matchers.containsString("NOT OK"))
        );
    }

    @Test
    void getUser() throws Exception {
        mockMvc.perform(get("/auth/user")
                .cookie(new Cookie("username", "Yossia"))
        ).andExpectAll(
            status().isOk(),
                content().string(Matchers.containsString("Hello Yossia"))
        );

    }
}
