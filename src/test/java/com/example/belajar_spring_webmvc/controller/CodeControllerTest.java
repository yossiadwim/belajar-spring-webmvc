package com.example.belajar_spring_webmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class CodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deleteProduct() throws Exception {
        mockMvc.perform(
                delete("/products/1")
        ).andExpectAll(
                status().isAccepted()
        );
    }
}
