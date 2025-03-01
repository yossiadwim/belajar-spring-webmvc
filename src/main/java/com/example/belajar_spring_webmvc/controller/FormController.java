package com.example.belajar_spring_webmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class FormController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping(path = "/form/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createPerson(
            @RequestParam("name") String name,
            @RequestParam("birthDate") Date birthDate,
            @RequestParam ("address") String address
    ){
      return "Success create person with name : " + name + ", birth date : " + dateFormat.format(birthDate) + ", address : " + address;
    }


    @PostMapping(value = "/form/hello", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    String hello(@RequestParam(name = "name", required = false) String name) {
        return """
                <html>
                <body>
                <h1>Hello $name</h1>
                </body>
                </html>
                """.replace("$name", name);
    }
}
