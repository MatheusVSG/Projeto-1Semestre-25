package com.projeto1.api_spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ExercicioController {

    @GetMapping("")

    public String Hello(){
        return "hello";
    }
    
}
