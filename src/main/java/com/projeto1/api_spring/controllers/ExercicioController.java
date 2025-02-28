package com.projeto1.api_spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ExercicioController {

    @GetMapping("")

    public String Hello(){
        return "hello";
    }

    @GetMapping("/get-idade/{idade}")
    public String RetornaIdade(@PathVariable Integer idade){

        try {
            if(idade < 0){
            throw new NumberFormatException();

            }
            if(idade < 12){
                return "Criança";

            }
            else if(idade <= 18){
                return "adolescente";
            
            }
            else if(idade <= 60){
                return "velho";

            }else{
                return "Adulto";

            }
        }catch(Exception e){
            return "idade invalida";
        }

    }

    @GetMapping("/getnum/{num}")
    public String RetornaNum(@PathVariable Integer num){
        try{
            if(num % 2 == 0){
                return "Par";
            }else{
                return "impar";
            }

        }catch(Exception e){
            return "numero invalido";

        }
    }
    
}
