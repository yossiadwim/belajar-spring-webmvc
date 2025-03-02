package com.example.belajar_spring_webmvc.controller;

import com.example.belajar_spring_webmvc.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class PersonController {

    @PostMapping(value = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> createPerson(@ModelAttribute @Valid CreatePersonRequest createPersonRequest,
                        BindingResult bindingResult) {

        List<FieldError> errors = bindingResult.getFieldErrors();

        if(!errors.isEmpty()){
            errors.forEach(error -> {
                System.out.println(error.getField() + " : " + error.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You send invalid data");
        }

        String response = "Success create person " +
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

        return ResponseEntity.ok(response);
    }
}
