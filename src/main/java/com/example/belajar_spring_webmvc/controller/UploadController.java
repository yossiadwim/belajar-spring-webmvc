package com.example.belajar_spring_webmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Controller
@Slf4j
public class UploadController {

    @PostMapping(value = "/upload/profile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String uploadProfile(
            @RequestParam("name") String name,
            @RequestPart("profile")MultipartFile profile

            ) throws IOException {
        Path path = Path.of("upload/" + profile.getOriginalFilename());
        profile.transferTo(path);

        return "Success save profile " + name + " to " + path.toString().replace("\\", "/");
    }
}
