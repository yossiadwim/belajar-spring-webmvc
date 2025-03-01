package com.example.belajar_spring_webmvc.controller;

import com.example.belajar_spring_webmvc.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PersonController {

    @PostMapping(value = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    String createPerson(@ModelAttribute @Valid CreatePersonRequest createPersonRequest) {
        return "Success create person " +
                createPersonRequest.getFirstName() + " " +
                createPersonRequest.getMiddleName() + " " +
                createPersonRequest.getLastName() + " " +
                "with email " + createPersonRequest.getEmail() + " " +
                "and phone " + createPersonRequest.getPhone() + " with address "
                + createPersonRequest.getAddress().getStreet()+ ", "
                + createPersonRequest.getAddress().getCity()+ ", "
                + createPersonRequest.getAddress().getCountry()
                + " and postal code " + createPersonRequest.getAddress().getPostalCode()+" with social media "
                + createPersonRequest.getSocialMedias().get(0).getName()+ " "
                + createPersonRequest.getSocialMedias().get(0).getLocation()+ " and hobbies "
                + createPersonRequest.getHobbies().get(0)+", "
                + createPersonRequest.getHobbies().get(1)+", "
                + createPersonRequest.getHobbies().get(2)
                ;
    }
}
