package com.example.belajar_spring_webmvc.controller;

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
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Yossia")
                        .param("middleName", "Dwi")
                        .param("lastName", "Mahardika")
                        .param("email", "yossia@example.com")
                        .param("phone", "08123456789")
                        .param("address.street", "Jl. Batu 1 No. 1")
                        .param("address.city", "Bandung")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "40111")
                        .param("hobbies[0]", "Gaming")
                        .param("hobbies[1]", "Coding")
                        .param("hobbies[2]", "Reading")
                        .param("socialMedias[0].name", "Instagram")
                        .param("socialMedias[0].location", "https://instagram.com/yossia.dwi.mahardika")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create person Yossia Dwi Mahardika with email yossia@example.com and phone 08123456789 with address Jl. Batu 1 No. 1, Bandung, Indonesia and postal code 40111 " +
                        "with social media Instagram https://instagram.com/yossia.dwi.mahardika and hobbies Gaming, Coding, Reading"))
        );
    }


    @Test
    void createPersonValidationError() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("middleName", "Dwi")
                        .param("lastName", "Mahardika")
                        .param("email", "yossia@example.com")
                        .param("phone", "08123456789")
                        .param("address.street", "Jl. Batu 1 No. 1")
                        .param("address.city", "Bandung")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "40111")
                        .param("hobbies[0]", "Gaming")
                        .param("hobbies[1]", "Coding")
                        .param("hobbies[2]", "Reading")
                        .param("socialMedias[0].name", "Instagram")
                        .param("socialMedias[0].location", "https://instagram.com/yossia.dwi.mahardika")
        ).andExpectAll(
                status().isBadRequest()
        );
    }
}