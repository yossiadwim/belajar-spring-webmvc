package com.example.belajar_spring_webmvc.controller;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void uploadFile() throws Exception {
        mockMvc.perform(multipart("/upload/profile")
                .file(new MockMultipartFile("profile", "profile.png", "image/png",
                        getClass().getResourceAsStream("images/profile.png")))
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .param("name", "Yossia")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success save profile Yossia to upload/profile.png"))
        );
    }
}
